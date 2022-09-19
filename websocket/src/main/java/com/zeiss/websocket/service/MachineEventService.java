package com.zeiss.websocket.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeiss.websocket.dto.MachineEventDTO;
import com.zeiss.websocket.vo.MachineEventQueryDTO;
import com.zeiss.websocket.vo.MachineEventVO;

public interface MachineEventService {
    void add(MachineEventDTO machineEventDTO);

    Page<MachineEventVO> findByQuery(MachineEventQueryDTO queryDTO);
}
