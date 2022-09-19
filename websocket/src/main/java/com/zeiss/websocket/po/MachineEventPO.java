package com.zeiss.websocket.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@TableName("t_machine_event")
public class MachineEventPO {
    private String topic;

    private String ref;

    private String event;

    private String machineId;

    @TableId(type = IdType.INPUT)
    private String id;

    private LocalDateTime timestamp;

    private String status;
}
