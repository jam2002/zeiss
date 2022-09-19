package com.zeiss.websocket.service.converter;

import com.zeiss.websocket.po.MachineEventPO;
import com.zeiss.websocket.vo.MachineEventVO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ModelConverter {
    MachineEventVO convertMachineEventVO(MachineEventPO machineEventPO);
}
