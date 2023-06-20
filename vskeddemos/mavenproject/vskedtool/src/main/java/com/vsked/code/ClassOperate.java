package com.vsked.code;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.vsked.common.ClassTool;

public class ClassOperate {
	
	private static final Logger log=LoggerFactory.getLogger(ClassOperate.class);

	public static void main(String[] args) {
		try {
			String cName="com.jsfirst.message.RequestConstants";
			Map<String, Object> resultMap=ClassTool.getFieldValueMap(cName);
			log.debug(resultMap+"");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}

	}

}
