package com.zeiss.websocket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineEventDTO {
    private String topic;
    private String ref;
    private String event;
    private MachineEventPayloadDTO payload;
}
