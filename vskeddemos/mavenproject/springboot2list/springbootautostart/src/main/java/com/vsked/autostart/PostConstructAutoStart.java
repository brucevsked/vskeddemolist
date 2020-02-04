package com.vsked.autostart;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostConstructAutoStart {
	
	private static final Logger log = LoggerFactory.getLogger(PostConstructAutoStart.class);
	
	@PostConstruct
	public void init() {
		log.debug("PostConstructAutoStart----------2------only one,只启动了一次,第2个启动");
	}

}
