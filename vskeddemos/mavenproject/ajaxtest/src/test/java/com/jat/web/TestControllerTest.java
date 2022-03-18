package com.jat.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.jat.test.BaseTestWithoutTransactional;


public class TestControllerTest extends BaseTestWithoutTransactional {

	private static final Logger log = LoggerFactory.getLogger(TestControllerTest.class);

	MockMvc mvc;

	@Autowired
	TestController testController;


	@BeforeClass
	public void initMvc() {
		mvc = MockMvcBuilders.standaloneSetup(testController).build();
	}
	
	@Test
	public void get1() throws Exception {
		RequestBuilder request = get("/get1");
		MvcResult mvcResult=mvc.perform(request).andReturn();
		String responseResult=mvcResult.getResponse().getContentAsString();
		log.info("{}",responseResult);
		Assert.assertEquals(responseResult,"no parameter get1");//实际返回值,预期值
	}

	@Test
	public void get2() throws Exception {
		String id="18";
		String name="little girl";
		RequestBuilder request = get("/get2")
				.param("id",id)
				.param("name",name);

		MvcResult mvcResult=mvc.perform(request).andReturn();
		String responseResult=mvcResult.getResponse().getContentAsString();
		log.info("{}",responseResult);
		Assert.assertEquals(responseResult,"id:["+id+"],name["+name+"]");
	}

	@Test
	public void post1() throws Exception {
		RequestBuilder request = post("/post1");
		MvcResult mvcResult=mvc.perform(request).andReturn();
		String responseResult=mvcResult.getResponse().getContentAsString();
		log.info("{}",responseResult);
		Assert.assertEquals(responseResult,"no parameter post1");//实际返回值,预期值
	}

	@Test
	public void post2() throws Exception {
		String id="18";
		String name="little girl";
		RequestBuilder request = post("/post2")
				.param("id",id)
				.param("name",name);

		MvcResult mvcResult=mvc.perform(request).andReturn();
		String responseResult=mvcResult.getResponse().getContentAsString();
		log.info("{}",responseResult);
		Assert.assertEquals(responseResult,"id:["+id+"],name["+name+"]");
	}

	@Test
	public void put1() throws Exception {
		RequestBuilder request = put("/put1");
		MvcResult mvcResult=mvc.perform(request).andReturn();
		String responseResult=mvcResult.getResponse().getContentAsString();
		log.info("{}",responseResult);
		Assert.assertEquals(responseResult,"no parameter put1");//实际返回值,预期值
	}

	@Test
	public void put2() throws Exception {
		String id="18";
		String name="little girl";
		RequestBuilder request = put("/put2")
				.param("id",id)
				.param("name",name);

		MvcResult mvcResult=mvc.perform(request).andReturn();
		String responseResult=mvcResult.getResponse().getContentAsString();
		log.info("{}",responseResult);
		Assert.assertEquals(responseResult,"id:["+id+"],name["+name+"]");
	}

	@Test
	public void patch1() throws Exception {
		RequestBuilder request = patch("/patch1");
		MvcResult mvcResult=mvc.perform(request).andReturn();
		String responseResult=mvcResult.getResponse().getContentAsString();
		log.info("{}",responseResult);
		Assert.assertEquals(responseResult,"no parameter patch1");//实际返回值,预期值
	}

	@Test
	public void patch2() throws Exception {
		String id="18";
		String name="little girl";
		RequestBuilder request = patch("/patch2")
				.param("id",id)
				.param("name",name);

		MvcResult mvcResult=mvc.perform(request).andReturn();
		String responseResult=mvcResult.getResponse().getContentAsString();
		log.info("{}",responseResult);
		Assert.assertEquals(responseResult,"id:["+id+"],name["+name+"]");
	}

	@Test
	public void delete1() throws Exception {
		RequestBuilder request = delete("/delete1");
		MvcResult mvcResult=mvc.perform(request).andReturn();
		String responseResult=mvcResult.getResponse().getContentAsString();
		log.info("{}",responseResult);
		Assert.assertEquals(responseResult,"no parameter delete1");//实际返回值,预期值
	}

	@Test
	public void delete2() throws Exception {
		String id="18";
		String name="little girl";
		RequestBuilder request = delete("/delete2")
				.param("id",id)
				.param("name",name);

		MvcResult mvcResult=mvc.perform(request).andReturn();
		String responseResult=mvcResult.getResponse().getContentAsString();
		log.info("{}",responseResult);
		Assert.assertEquals(responseResult,"id:["+id+"],name["+name+"]");
	}
	
}
