package com.vsked.auth.web;

import com.vsked.BaseApplicationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class SessionControllerTest extends BaseApplicationTest {

    MockMvc mvc;

    @Autowired
    SessionController sessionController;

    @BeforeClass
    public void initMvc(){
        mvc = MockMvcBuilders.standaloneSetup(sessionController).build();
    }

    @Test
    public void login() throws Exception {
        RequestBuilder request = post("/session")
                .param("username", "vskeda1username")
                .param("password", "mypassword is unknown");
        mvc.perform(request)
                .andExpect(content().string(equalTo("good")));

    }
}
