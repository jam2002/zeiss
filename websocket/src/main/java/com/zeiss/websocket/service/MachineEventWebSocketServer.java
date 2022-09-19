package com.zeiss.websocket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeiss.websocket.dto.MachineEventDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Slf4j
@Component
@ServerEndpoint("/ws")
public class MachineEventWebSocketServer {

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private MachineEventService machineEventService;

    @OnOpen
    public void onOpen(Session session) {
        log.info("建立新连接：" + session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        log.info("关闭新连接：" + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息：{}", message);
        if (StringUtils.hasLength(message)) {
            try {
                MachineEventDTO machineEventDTO = objectMapper.readValue(message, MachineEventDTO.class);
                machineEventService.add(machineEventDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
