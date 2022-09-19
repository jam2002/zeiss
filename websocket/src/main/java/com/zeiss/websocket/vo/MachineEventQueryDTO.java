package com.zeiss.websocket.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MachineEventQueryDTO {
    private String machineId;
    private List<String> status;
    private List<String> events;
    private LocalDateTime beginTIme;
    private LocalDateTime endTime;

    private Integer current = 1;
    private Integer pageSize = 10;
}
