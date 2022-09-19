package com.zeiss.websocket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineEventPayloadDTO {
    @JsonProperty("machine_id")
    private String machineId;
    private String id;
    private String timestamp;
    private String status;
}
