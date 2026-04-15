package com.vsked.auth.web;

import com.vsked.auth.web.model.ExternalApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.vsked.auth.service.TestWebService;

@RestController
@RequestMapping("/test")
public class TestWebFileController {

	@Autowired
	private TestWebService testWebService;

	private static final Logger log = LoggerFactory.getLogger(TestWebController.class);

	@RequestMapping("/input")
	public String logUpload(@RequestParam("inputFile") MultipartFile[] fileArray,
			@RequestParam("inputText") String text, @RequestParam("inputTextarea") String textarea) throws Exception {
		if(log.isTraceEnabled()){
			log.trace("start");
		}

		String uploadResult=testWebService.testFileOutput(fileArray, text, textarea);

		if(log.isInfoEnabled()){
			log.info("uploadResult is:{}",uploadResult);
		}

		if(log.isTraceEnabled()){
			log.trace("end");
		}
		return uploadResult;
	}

	@PostMapping(value="/uploadFile")
	public String uploadFile(@RequestPart("externalApi") ExternalApi externalApi, @RequestPart("file") MultipartFile file){

		/* 使用的curl命令
		 curl --location --request POST "http://127.0.0.1:80/test/uploadFile" ^
		 --header "Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW" ^
		 --form "externalApi={\"name\":\"vsked\",\"url\":\"http://www.baidu.com\",\"type\":\"string\"};type=application/json" ^
		 --form "file=@\"D:\\03_00_6702_00_20260414102316131000000000000001.bin\""
		 */

		log.info("{}",externalApi);
		log.info("{}",file.getOriginalFilename());
		return "success"+externalApi.getName()+"|"+externalApi.getUrl()+"|"+file.getOriginalFilename();
	}

}
