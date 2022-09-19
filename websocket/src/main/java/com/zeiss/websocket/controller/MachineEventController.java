package com.zeiss.websocket.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeiss.websocket.dto.ActionResult;
import com.zeiss.websocket.dto.MachineEventDTO;
import com.zeiss.websocket.service.MachineEventService;
import com.zeiss.websocket.vo.MachineEventQueryDTO;
import com.zeiss.websocket.vo.MachineEventVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("machineEvent")
@Api(tags = "机器事件数据")
public class MachineEventController {

    @Resource
    private MachineEventService machineEventService;

    @ApiOperation("查询")
    @PostMapping("list")
    public ActionResult<Page<MachineEventVO>> list(@RequestBody MachineEventQueryDTO queryDTO) {
        return ActionResult.success(machineEventService.findByQuery(queryDTO));
    }

    @ApiOperation("测试消息添加")
    @PostMapping("testAdd")
    public ActionResult<Boolean> testAdd(@RequestBody String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MachineEventDTO machineEventDTO = objectMapper.readValue(message, MachineEventDTO.class);
            machineEventService.add(machineEventDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.success(false);
        }
        return ActionResult.success(true);
    }
}
