package com.jat.auth.web;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.reactive.function.client.WebClient;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.jat.test.BaseTest;

import reactor.core.publisher.Mono;

public class TestControllerTest extends BaseTest{
	
	private static final Logger log = LoggerFactory.getLogger(TestControllerTest.class);
	
	WebClient webClient;
	
    @Autowired
    TestController testController;
    
    @BeforeClass
    public void initMvc(){
    	//webClient = WebClient.create();
    	//webClient = WebClient.create("http://127.0.0.1:8181");
    }
    
    @Test
    public void test1() throws Exception {
    	String reqUrl="http://127.0.0.1:8181";
    	webClient=WebClient.builder().baseUrl(reqUrl).build();
    	Mono<String> respMono=webClient.get().uri("/test1").retrieve().bodyToMono(String.class);
    	log.info("|"+respMono.block()+"|");
    }
    
}
