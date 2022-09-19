package com.zeiss.websocket.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeiss.websocket.dao.MachineEventMapper;
import com.zeiss.websocket.dto.MachineEventDTO;
import com.zeiss.websocket.po.MachineEventPO;
import com.zeiss.websocket.service.MachineEventService;
import com.zeiss.websocket.service.converter.ModelConverter;
import com.zeiss.websocket.vo.MachineEventQueryDTO;
import com.zeiss.websocket.vo.MachineEventVO;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Service
public class MachineEventServiceImpl implements MachineEventService {
    @Resource
    private MachineEventMapper machineEventMapper;

    @Resource
    private ModelConverter modelConverter;

    private static final String FMT_TIME_4 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'";

    @Override
    public void add(MachineEventDTO machineEventDTO) {
        MachineEventPO machineEventPO = new MachineEventPO();
        machineEventPO.setEvent(machineEventDTO.getEvent());
        machineEventPO.setTopic(machineEventDTO.getTopic());
        machineEventPO.setRef(machineEventDTO.getRef());
        machineEventPO.setId(machineEventDTO.getPayload().getId());
        machineEventPO.setMachineId(machineEventDTO.getPayload().getMachineId());
        machineEventPO.setStatus(machineEventDTO.getPayload().getStatus());
        machineEventPO.setTimestamp(LocalDateTime.parse(machineEventDTO.getPayload().getTimestamp(), DateTimeFormatter.ofPattern(FMT_TIME_4)));
        machineEventMapper.insert(machineEventPO);
    }

    @Override
    public Page<MachineEventVO> findByQuery(MachineEventQueryDTO queryDTO) {
        Page<MachineEventPO> page = new Page<>();
        page.setSize(queryDTO.getPageSize());
        page.setCurrent(queryDTO.getCurrent());

        LambdaQueryWrapper<MachineEventPO> wrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(queryDTO.getMachineId())) {
            wrapper = wrapper.eq(MachineEventPO::getMachineId, queryDTO.getMachineId());
        }
        if (CollectionUtil.isNotEmpty(queryDTO.getEvents())) {
            wrapper = wrapper.in(MachineEventPO::getEvent, queryDTO.getEvents());
        }
        if (CollectionUtil.isNotEmpty(queryDTO.getStatus())) {
            wrapper = wrapper.in(MachineEventPO::getStatus, queryDTO.getStatus());
        }
        if (queryDTO.getBeginTIme() != null) {
            wrapper = wrapper.ge(MachineEventPO::getTimestamp, queryDTO.getBeginTIme());
        }
        if (queryDTO.getEndTime() != null) {
            wrapper = wrapper.lt(MachineEventPO::getTimestamp, queryDTO.getEndTime());
        }
        Page<MachineEventPO> result = machineEventMapper.selectPage(page, wrapper);
        Page<MachineEventVO> newResult = new Page<>();
        newResult.setCurrent(result.getCurrent());
        newResult.setSize(result.getSize());
        newResult.setTotal(result.getTotal());
        newResult.setRecords(result.getRecords().stream().map(t -> modelConverter.convertMachineEventVO(t)).collect(Collectors.toList()));
        return newResult;
    }
}
