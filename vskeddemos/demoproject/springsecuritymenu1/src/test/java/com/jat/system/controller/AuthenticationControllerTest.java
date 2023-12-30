package com.jat.system.controller;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.testng.annotations.Test;

@AutoConfigureMockMvc //自动配置mvc注解
public class AuthenticationControllerTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationControllerTest.class);

    @Autowired
    MockMvc mvc;

    @Test
    public void create() throws Exception {
        RequestBuilder reqBuilder = post("/api/authentication")
                .param("name", "admin")
                .param("password", "admin");
        String respStr=mvc.perform(reqBuilder)
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        log.info("{}",respStr);

    }

    @Test
    public void system_admin() throws Exception {
        //超级管理员拥有全部地址访问权限
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Bearer","1");
        RequestBuilder reqBuilder = post("/system")
                .headers(httpHeaders);
        String respStr=mvc.perform(reqBuilder)
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        log.info("{}",respStr);

    }

    @Test
    public void system_userNot() throws Exception {
        //普通用户没有访问权限
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Bearer","2");
        RequestBuilder reqBuilder = post("/system")
                .headers(httpHeaders);
        String respStr=mvc.perform(reqBuilder)
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        log.info("{}",respStr);

    }

    @Test
    public void system_userOk() throws Exception {
        //普通用户有的访问权限
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Bearer","2");
        RequestBuilder reqBuilder = post("/system/userList")
                .headers(httpHeaders);
        String respStr=mvc.perform(reqBuilder)
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        log.info("{}",respStr);

    }
}
