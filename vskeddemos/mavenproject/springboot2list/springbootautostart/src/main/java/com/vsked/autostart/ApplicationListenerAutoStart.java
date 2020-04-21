package com.vsked.autostart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerAutoStart implements ApplicationListener<ApplicationEvent>{
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationListenerAutoStart.class);

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		log.debug("ApplicationListenerAutoStart----------3------many times,启动了很多次,第3个启动 stop will run it");
	}

}
