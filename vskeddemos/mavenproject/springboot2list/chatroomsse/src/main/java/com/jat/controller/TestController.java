package com.jat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	private static Map<String, SseEmitter> sseCache = new ConcurrentHashMap<>();

	@RequestMapping(value = "pushData",produces = "text/event-stream")
	public SseEmitter sendData(String clientId){
        // 超时时间设置为1小时
		SseEmitter sseEmitter = new SseEmitter(3600_000L);
		sseCache.put(clientId, sseEmitter);
		sseEmitter.onTimeout(() -> System.out.println("删除会话id"));
		sseEmitter.onCompletion(() -> System.out.println("完成！！！"));
		return sseEmitter;
	}

	@GetMapping(path = "push")
	public String push(String clientId, String content) throws IOException {
		SseEmitter sseEmitter = sseCache.get(clientId);
		if (sseEmitter != null) {
			sseEmitter.send(content);
		}
		return "{\"code\":\"0000\"}";
	}

	@GetMapping(path = "over")
	public String over(String id) {
		SseEmitter sseEmitter = sseCache.get(id);
		if (sseEmitter != null) {
			sseEmitter.complete();
			sseCache.remove(id);
		}
		return "{\"code\":\"9999\"}";
	}


}
