package com.jat.system.controller;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.testng.annotations.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc //自动配置mvc注解
public class LogoutControllerTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(LogoutControllerTest.class);

    @Autowired
    MockMvc mvc;

    @Test
    public void logout() throws Exception {
        RequestBuilder reqBuilder = delete("/api/logout")
                .param("certificateId", "1");
        String respStr=mvc.perform(reqBuilder)
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        log.info("{}",respStr);

    }
}
