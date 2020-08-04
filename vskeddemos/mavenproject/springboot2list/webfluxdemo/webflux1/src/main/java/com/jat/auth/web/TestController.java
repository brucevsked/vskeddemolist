package com.jat.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.jat.auth.service.TestService;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
    TestService testService;
	
	@Bean
    public RouterFunction<ServerResponse> routerFunction() {
		log.info("this is new flux");
        return route(GET("/test1"), testService::getAll);
               // .andRoute(GET("/webflux/users"),userHandler::getAll);
    }
}
