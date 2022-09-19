package com.zeiss.websocket.service.converter;

import com.zeiss.websocket.po.MachineEventPO;
import com.zeiss.websocket.vo.MachineEventVO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-13T19:49:32+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class ModelConverterImpl implements ModelConverter {

    @Override
    public MachineEventVO convertMachineEventVO(MachineEventPO machineEventPO) {
        if ( machineEventPO == null ) {
            return null;
        }

        MachineEventVO machineEventVO = new MachineEventVO();

        if ( machineEventPO.getTopic() != null ) {
            machineEventVO.setTopic( machineEventPO.getTopic() );
        }
        if ( machineEventPO.getRef() != null ) {
            machineEventVO.setRef( machineEventPO.getRef() );
        }
        if ( machineEventPO.getEvent() != null ) {
            machineEventVO.setEvent( machineEventPO.getEvent() );
        }
        if ( machineEventPO.getMachineId() != null ) {
            machineEventVO.setMachineId( machineEventPO.getMachineId() );
        }
        if ( machineEventPO.getId() != null ) {
            machineEventVO.setId( machineEventPO.getId() );
        }
        if ( machineEventPO.getTimestamp() != null ) {
            machineEventVO.setTimestamp( machineEventPO.getTimestamp() );
        }
        if ( machineEventPO.getStatus() != null ) {
            machineEventVO.setStatus( machineEventPO.getStatus() );
        }

        return machineEventVO;
    }
}
