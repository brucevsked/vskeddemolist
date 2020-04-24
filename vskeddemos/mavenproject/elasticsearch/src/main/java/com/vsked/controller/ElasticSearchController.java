package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ElasticSearchController {
	
	@RequestMapping("/essave")
	@ResponseBody
	public String save(HttpServletRequest r) {
		
		log.info(r.getParameter("tbname"));
		log.info(r.getParameter("k"));
		log.info(r.getParameter("v"));
		
		/*
		BulkResponse bulkResponse = null;
		try {
		// 构造查询客户端 for elastic search 7.6.2
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));
		BulkRequest request = new BulkRequest(); 
		request.add(new IndexRequest("posts").id("3")  
		        .source(XContentType.JSON,"field", "baz"));
		request.timeout(TimeValue.timeValueMinutes(2)); 
		request.timeout("2m"); 
		bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
		client.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bulkResponse.toString();
		*/
		return "hello world";
		
	}

}
