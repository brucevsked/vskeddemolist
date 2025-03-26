package com.vsked.auth.web;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.File;
import java.io.FileInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.vsked.test.BaseTestWithoutTransactional;

@AutoConfigureMockMvc //自动配置mvc注解
public class TestControllerTest extends BaseTestWithoutTransactional {

	private static final Logger log = LoggerFactory.getLogger(TestControllerTest.class);

	@Autowired
	MockMvc mvc;

	@Test
	public void test1() throws Exception {
		log.info("TestControllerTest test1 start ");
		// 用来测试post,前端传值时直接传参数，后端封装成对象用@ModelAttribute
		RequestBuilder reqBuilder = post("/test")
				.param("username", "vskeda1username")
				.param("password", "mypassword is unknown");
		String respStr=mvc.perform(reqBuilder)
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn()
				.getResponse()
				.getContentAsString();

		log.info("{}",respStr);

		Assert.assertEquals(respStr,"jinan37001");
		log.info("TestControllerTest test1 end ");
	}

	@Test
	public void test3() throws Exception {
		log.info("TestControllerTest test2 start ");
		// 用来测试get,前端在请求路径或问号后面传参数时，
		// 后端封装用@PathVariable("ida") String id 或 @RequestParam("username") String username
		RequestBuilder request = get("/test/9631").param("username", "vskeda1username").param("password",
				"mypassword is unknown");
		mvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string(equalTo("9631testokvskeda1usernamemypassword is unknown")));
		log.info("TestControllerTest test2 end ");
	}

	@Test
	public void fileTest() throws Exception {
		log.info("TestControllerTest fileTest start ");
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.multipart("/test/input")
				.file(new MockMultipartFile("inputFile", "newtest1.gif", "application/ms-excel",
						new FileInputStream(new File("C:/Users/developer3/Desktop/测试图片/Stamp/aaa.gif"))))
				.file(new MockMultipartFile("inputFile", "newtest2.gif", "application/ms-excel",
						new FileInputStream(new File("C:/Users/developer3/Desktop/测试图片/Stamp/bbb.gif"))))
				.param("inputText", "11111111").param("inputTextarea", "22222")
				);
		MvcResult mvcResult = resultActions.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        log.info("==========结果为：==========\\n " + result + "\n" );
        log.info("TestControllerTest fileTest end ");
	}
	
}
