package com.vsked.auth.application.service;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SessionApplicationService {
	
	private static final Logger log = LoggerFactory.getLogger(SessionApplicationService.class);

	public String createSession(HttpServletRequest request) {
		log.info("create session ok in service");
		log.debug(request.getParameter("token"));
		return "good luck";
	}


}
