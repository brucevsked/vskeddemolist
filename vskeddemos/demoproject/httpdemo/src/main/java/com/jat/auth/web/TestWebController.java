package com.jat.auth.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jat.common.Request;

@Controller  
public class TestWebController {
    
	private static final Logger log = LoggerFactory.getLogger(TestWebController.class);
	
    @GetMapping("/")
    public String test(){
    	log.info("TestWebController test start");
        return "TestFile.html"; 
    }
    
    @RequestMapping("/testurl")
    @ResponseBody
    public String testUrl(HttpServletRequest req) throws Exception {
    	log.info("test start");
    	log.info(req.getMethod());
    	log.info(req.getContentType());
    	
    	
    	if(req.getContentType().indexOf("json")>0) {
    		String reqParamater=Request.getStringFromStream(req, "utf-8");
    		log.debug(reqParamater+"");
    		return req.getMethod()+"test ok"+reqParamater;
    	}
    	log.debug(Request.getMaps(req)+"");
    	return req.getMethod()+"test ok"+Request.getMaps(req);
    }

}
