package com.zeiss.websocket.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MachineEventVO {
    private String topic;

    private String ref;

    private String event;

    private String machineId;

    private String id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private String status;
}
