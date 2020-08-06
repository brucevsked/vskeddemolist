package com.jat.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.testng.annotations.Test;
import com.jat.test.BaseTest;
import reactor.core.publisher.Mono;

@AutoConfigureWebTestClient
public class TestControllerTest extends BaseTest{
	
	private static final Logger log = LoggerFactory.getLogger(TestControllerTest.class);
	
	WebClient webClient;

    @Autowired
	private WebTestClient webTestClient;
	
    @Autowired
    TestController testController;

    
    @Test
    public void test1() {
        //需要先启动应用才可以跑这个单元测试，只是一种请求发送技术并非单元测试技术
    	String reqUrl="http://127.0.0.1:8181";
    	webClient=WebClient.builder().baseUrl(reqUrl).build();
    	Mono<String> respMono=webClient.get().uri("/test1").retrieve().bodyToMono(String.class);
    	log.info("|"+respMono.block()+"|");

    	//其他注意 此webClient技术还可以用okhttp,retrofit等技术替代
    }

    @Test
    public void test1a() {
        //会自动启动应用 是一种单元测试技术 单元测试推荐用这种
        String reqUrl="http://127.0.0.1:8181";
        String respStr=webTestClient.get().uri("/test1").exchange()
                .expectStatus().isOk()
                .returnResult(String.class).getResponseBody()
                .blockFirst();
        log.info("|"+respStr+"|");
    }
    
}
