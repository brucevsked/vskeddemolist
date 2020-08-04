package com.jat.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TestService {
	
	private static final Logger log = LoggerFactory.getLogger(TestService.class);
	
    public String test1(){
    	log.info("TestService start");
        String result="testok1";
        log.debug("|"+result+"|");
        log.info("TestService end");
        return result;
    }
    
    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        printlnThread("获用户数据");
        Flux<String> userFlux = Flux.just("usertest1a");
        return ServerResponse.ok().body(userFlux, String.class);
    }
    
    /**
     * 打印当前线程
     * @param object
     */
    private void printlnThread(Object object) {
        String threadName = Thread.currentThread().getName();
        log.debug("TestService[" + threadName + "]: " + object);
    }
}
