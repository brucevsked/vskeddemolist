package com.vsked.autostart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitializingBeanAutoStart implements InitializingBean{
	
	private static final Logger log = LoggerFactory.getLogger(InitializingBeanAutoStart.class);

	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("InitializingBeanAutoStart----------1------only one,只启动了一次,第1个启动");
	}

}
