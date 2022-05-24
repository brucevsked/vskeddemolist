package com.jat.user;

import com.jat.test.BaseTestWithoutTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testng.Assert;
import org.testng.annotations.Test;


@AutoConfigureWebTestClient
public class UserTest extends BaseTestWithoutTransactional {
    private static final Logger log = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private WebTestClient webClient;

    @Test
    void testHelloPredicates() {
        webClient.get()
                .uri("/getUser?id=test1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                // 验证状态
                .expectStatus().isOk()
                // 验证结果，注意结果是字符串格式
                .expectBody(String.class).consumeWith(response-> {
                    log.info("响应结果是:{}",response);
                    Assert.assertTrue(response.getResponseBody().contains("Hello Nacos Discovery"));

                });
    }

}
