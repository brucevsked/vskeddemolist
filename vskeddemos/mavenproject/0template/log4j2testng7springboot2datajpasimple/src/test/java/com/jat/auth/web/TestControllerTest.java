package com.jat.auth.web;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.testng.annotations.Test;
import com.jat.test.BaseTestWithTransactional;

@AutoConfigureMockMvc //自动配置mvc注解
public class TestControllerTest extends BaseTestWithTransactional {
	
	private static final Logger log = LoggerFactory.getLogger(TestControllerTest.class);

	@Autowired
	MockMvc mvc;


	@Test
	public void add() throws Exception {
		log.trace("TestControllerTest add start");
		//用来测试post,前端传值时直接传参数，后端封装成对象用@ModelAttribute
		RequestBuilder reqBuilder = post("/addAccount")
                .param("id", "2")
                .param("username", "usernameadd2")
				.param("password", "passwordadd2");
		String respStr=mvc.perform(reqBuilder)
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn()
				.getResponse()
				.getContentAsString();
		log.info("{}",respStr);

		log.trace("TestControllerTest add end");
	}

	@Test
	public void update() throws Exception {
		log.trace("TestControllerTest update start");
		//用来测试post,前端传值时直接传参数，后端封装成对象用@ModelAttribute
		RequestBuilder request = post("/updateAccount")
				.param("id", "2")
				.param("username", "updateusername2")
				.param("password", "updatepass2");
		mvc.perform(request);
		log.trace("TestControllerTest update end");
	}

	@Test
	public void delete() throws Exception {
		log.trace("TestControllerTest delete start");
		//用来测试post,前端传值时直接传参数，后端封装成对象用@ModelAttribute
		RequestBuilder request = post("/deleteAccount")
				.param("id", "2");
		mvc.perform(request)
		.andExpect(content().string(equalTo("1")));
		log.trace("TestControllerTest delete end");
	}

	@Test
	public void search() throws Exception {
		log.trace("TestControllerTest search start");
		//用来测试post,前端传值时直接传参数，后端封装成对象用@ModelAttribute
		RequestBuilder request = post("/searchAccount")
				.param("id", "1");
		mvc.perform(request);
		log.trace("TestControllerTest search end");
	}
	
}
