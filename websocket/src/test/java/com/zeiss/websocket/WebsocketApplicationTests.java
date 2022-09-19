package com.zeiss.websocket;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeiss.websocket.dto.MachineEventDTO;
import com.zeiss.websocket.service.MachineEventService;
import com.zeiss.websocket.vo.MachineEventQueryDTO;
import com.zeiss.websocket.vo.MachineEventVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WebsocketApplicationTests {

	@Resource
	private MachineEventService machineEventService;

	@Test
	void contextLoads() {
	}

	@Test
	public void test1(){
		ObjectMapper objectMapper = new ObjectMapper();
		String message = "{\"topic\":\"events\",\"ref\":null,\"payload\":{\"machine_id\":\"59d9f4b4-018f-43d8-92d0-c51de7d987e5\",\"id\":\"41bb0908-15ba-4039-8c4f-8b7b99260eb2\",\"timestamp\":\"2017-04-16T19:42:26.542614Z\",\"status\":\"running\"},\"event\":\"new\"}";
		try {
			MachineEventDTO machineEventDTO = objectMapper.readValue(message, MachineEventDTO.class);
			machineEventService.add(machineEventDTO);
		}catch (Exception e){
			e.printStackTrace();
		}

		MachineEventQueryDTO queryDTO = new MachineEventQueryDTO();
		queryDTO.setMachineId("59d9f4b4-018f-43d8-92d0-c51de7d987e5");
		Page<MachineEventVO> page = machineEventService.findByQuery(queryDTO);
	}

}
