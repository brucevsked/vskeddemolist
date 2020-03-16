package com.vsked.service.kafka;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonalService implements SaveDataInterface{
	
	private static final Logger log = LoggerFactory.getLogger(PersonalService.class);

	@Override
	public int saveData(Map<String, Object> inputData) {
		try {
			log.info("-------------start-----------------person"+inputData.get("count"));
			Thread.sleep(5000);
			log.info("-------------end-----------------person"+inputData.get("count"));
		}catch(Exception e) {
			
		}
		return 0;
	}

}
