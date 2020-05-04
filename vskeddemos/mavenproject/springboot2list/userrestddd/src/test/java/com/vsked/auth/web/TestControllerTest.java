package com.vsked.auth.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsked.BaseApplicationTest;
import com.vsked.auth.web.model.LoginInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TestControllerTest extends BaseApplicationTest {



    MockMvc mvc;

    @Autowired
    TestController testController;

    @BeforeClass
    public void initMvc(){
        mvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void test1() throws Exception {
        /**
         * 用来测试post,前端传值时直接传参数，后端封装成对象用@ModelAttribute
         */
        RequestBuilder request = post("/test")
                .param("username", "vskeda1username")
                .param("password", "mypassword is unknown");
        mvc.perform(request)
                .andExpect(content().string(equalTo("testok1")));

    }

    @Test
    public void test2() throws Exception {
        /**
         * 用来测试get,前端在请求路径或问号后面传参数时，后端封装用@PathVariable("ida") String id 或 @Param("username") String username
         */
        RequestBuilder request = get("/test/9631")
                .param("username", "vskeda1username")
                .param("password", "mypassword is unknown");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("9631testok2vskeda1username")));

    }

    @Test
    public void test3() throws Exception {
        /**
         * 用来测试post,
         * 前端传值时需要指定媒体类型为application/json
         * 并将要传的参数封装成json字符串，
         * 后端封装成对象用@RequestBody
         */
        MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
        ObjectMapper jackson = new ObjectMapper();

        String requestJson=jackson.writeValueAsString(new LoginInfoVO("name3","pass3"));

        RequestBuilder request = post("/test/t3")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson);
        mvc.perform(request)
                .andExpect(content().string(equalTo("testok3")));

    }

}
