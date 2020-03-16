package com.vsked.service.kafka;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FootBallService implements SaveDataInterface{
	
	private static final Logger log = LoggerFactory.getLogger(FootBallService.class);

	@Override
	public int saveData(Map<String, Object> inputData) {
		try {
			log.info("-------------start-----------------FootBall"+inputData.get("count"));
			Thread.sleep(6000);
			log.info("-------------end-----------------FootBall"+inputData.get("count"));
		}catch(Exception e) {
			
		}
		return 0;
	}

}
