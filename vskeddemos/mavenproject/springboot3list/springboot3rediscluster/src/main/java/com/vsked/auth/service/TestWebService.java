package com.vsked.auth.service;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.vsked.auth.web.TestWebController;

@Service
public class TestWebService {

	private static final Logger log = LoggerFactory.getLogger(TestWebController.class);

	public String testFileOutput(MultipartFile[] fileArray, String text, String textarea) {
		if(log.isTraceEnabled()){
			log.trace("start");
		}
        if(log.isInfoEnabled()){
			log.info("输入标题：{}" , text);
			log.info("输入内容：{}" , textarea);
		}

		int uploadCount = 0;
		int repetitionCount = 0;
		int errCount = 0;
		int fileSum = fileArray.length;
		String filePath = "/test"; //保存路径
		File fileUpload = new File(filePath);
		if (!fileUpload.exists()) {
			fileUpload.mkdirs();
		}
		for (MultipartFile file : fileArray) {
			if (file == null || file.isEmpty()) {
				fileSum--;
				continue;
			}
			fileUpload = new File(filePath, Objects.requireNonNull(file.getOriginalFilename()));
			if (fileUpload.exists()) {
				log.info("上传的文件已存在: " + file.getOriginalFilename());
				repetitionCount++;
				continue;
			}
			try {
				file.transferTo(fileUpload);
				uploadCount++;
			} catch (IOException e) {
				log.error("上传文件到服务器失败：{}",file.getOriginalFilename(),e);
				errCount++;
			}
		}

		String uploadResult=" 输入标题：" + text
				+ "  输入内容：" + textarea
				+ "  上传完成！总数：" + (fileSum - repetitionCount)
				+ " 成功数量："+ uploadCount
				+ " 失败数量：" + errCount
				+ " 重复数量：" + repetitionCount;

		if(log.isTraceEnabled()){
			log.trace("start");
		}

		return uploadResult;
	}

}
