package com.vsked.service.kafka;

import java.util.Map;

public class TaskDispatch implements Runnable{
	
	SaveDataInterface saveData;
	Map<String, Object> inputData;
	
	public TaskDispatch(SaveDataInterface saveData, Map<String, Object> inputData) {
		super();
		this.saveData = saveData;
		this.inputData = inputData;
	}



	@Override
	public void run() {
		saveData.saveData(inputData);
	}

}
