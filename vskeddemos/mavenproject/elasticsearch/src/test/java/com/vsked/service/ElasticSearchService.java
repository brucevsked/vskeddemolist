package com.vsked.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.junit.Test;

import com.vsked.test.BaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ElasticSearchService extends BaseTest {


	
//	@Test
	public void addBatchTest() {
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));
			BulkRequest request = new BulkRequest(); 
			request.add(new IndexRequest("posts").id("1")  
			        .source(XContentType.JSON,"field", "foo"));
			request.add(new IndexRequest("posts").id("2")  
			        .source(XContentType.JSON,"field", "bar"));
			request.add(new IndexRequest("posts").id("3")  
			        .source(XContentType.JSON,"field", "baz"));
			request.timeout(TimeValue.timeValueMinutes(2)); 
			request.timeout("2m"); 
			BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
			log.info(bulkResponse.toString());
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

//	@Test
	public void getRequestTest() {
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));
			GetRequest getRequest = new GetRequest(
			        "posts", 
			        "9");  
			GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
			String message = getResponse.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void getAllRequestTest() {
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));
			SearchRequest searchRequest=new SearchRequest("posts");
			SearchResponse searchResponse=client.search(searchRequest, RequestOptions.DEFAULT);
			String message = searchResponse.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void indexRequest1Test() {//json
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));

			IndexRequest indexRequest = new IndexRequest("posts"); 
			indexRequest.id("2"); 
			String jsonString = "{" +
			        "\"user\":\"kimchy\"," +
			        "\"postDate\":\"2013-01-30\"," +
			        "\"message\":\"trying out Elasticsearch\"," +
			        "\"count\":8" +
			        "}";
			indexRequest.source(jsonString, XContentType.JSON);
			IndexResponse indexResponse=client.index(indexRequest, RequestOptions.DEFAULT);
			String message = indexResponse.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void indexRequest2Test() {//map
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));

			IndexRequest indexRequest = new IndexRequest("posts"); 
			indexRequest.id("5"); 
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("user", "kimchymap");
			jsonMap.put("postDate", new Date());
			jsonMap.put("message", "trying out Elasticsearchmap");
			indexRequest.source(jsonMap);
			IndexResponse indexResponse=client.index(indexRequest, RequestOptions.DEFAULT);
			String message = indexResponse.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void indexRequest3Test() {//ContentBuilder
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));

			IndexRequest indexRequest = new IndexRequest("posts"); 
			indexRequest.id("6"); 
			XContentBuilder builder = XContentFactory.jsonBuilder();
			builder.startObject();
			{
			    builder.field("user", "kimchyContentBuilder");
			    builder.timeField("postDate", new Date());
			    builder.field("message", "trying out ElasticsearchContentBuilder");
			}
			builder.endObject();
			indexRequest.source(builder);
			IndexResponse indexResponse=client.index(indexRequest, RequestOptions.DEFAULT);
			String message = indexResponse.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void deleteRequest1Test() {
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));

			DeleteRequest request = new DeleteRequest(
			        "posts",    
			        "3");  
			DeleteResponse response=client.delete(request, RequestOptions.DEFAULT) ;
			String message = response.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void updateRequest1Test() { //script update
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));

			UpdateRequest request = new UpdateRequest(
			        "posts", 
			        "1"); 
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ct", 4);

			Script inline = new Script(ScriptType.INLINE, "painless",
			        "ctx._source.count += params.ct", parameters);  
			request.script(inline);  
			UpdateResponse response=client.update(request, RequestOptions.DEFAULT) ;
			String message = response.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void updateRequest2Test() {//json update
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));

			UpdateRequest request = new UpdateRequest(
			        "posts", 
			        "2"); 
			String jsonString = "{" +
			        "\"user\":\"newuserforyou\"," +
			        "\"count\":1" +
			        "}";
			//只会更新存在的
			request.doc(jsonString, XContentType.JSON);
			UpdateResponse response=client.update(request, RequestOptions.DEFAULT) ;
			String message = response.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void updateRequest3Test() {//map update
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));

			UpdateRequest request = new UpdateRequest(
			        "posts", 
			        "5"); 
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("user", "kimchymap666");
			jsonMap.put("postDate", new Date());
			jsonMap.put("message", "================");
			request.doc(jsonMap);
			UpdateResponse response=client.update(request, RequestOptions.DEFAULT) ;
			String message = response.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void updateRequest4Test() {//ContentBuilder update
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));

			UpdateRequest request = new UpdateRequest(
			        "posts", 
			        "6"); 
			XContentBuilder builder = XContentFactory.jsonBuilder();
			builder.startObject();
			{
			    builder.timeField("postDate", new Date());
			    builder.field("message", "daily update");
			}
			builder.endObject();
			request.doc(builder);
			UpdateResponse response=client.update(request, RequestOptions.DEFAULT) ;
			String message = response.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void updateRequest5Test() {//key-pairs update
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));

			UpdateRequest request = new UpdateRequest(
			        "posts", 
			        "6").doc("postDate",new Date(),"message","good luck girl"); 
			UpdateResponse response=client.update(request, RequestOptions.DEFAULT) ;
			String message = response.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Test
	public void upsertRequest1Test() {//upsert
		try {
			// 构造查询客户端 for elastic search 7.6.2
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("10.0.193.10", 9222, "http")));
			UpdateRequest request = new UpdateRequest(
			        "posts", 
			        "9"); 
			String jsonString = "{" +
			        "\"user\":\"newuserforyou\"," +
			        "\"count\":1" +
			        "}";
			//只会更新存在的
			request.doc(jsonString, XContentType.JSON);
			IndexRequest indexRequest = new IndexRequest("posts"); 
			indexRequest.id("9"); 
			jsonString = "{" +
			        "\"user\":\"kimchyaaaaaaa\"," +
			        "\"postDate\":\"2013-01-30\"," +
			        "\"message\":\"trying out Elasticsearch\"," +
			        "\"count\":8" +
			        "}";
			indexRequest.source(jsonString, XContentType.JSON);
			request.upsert(indexRequest);
			UpdateResponse response=client.update(request, RequestOptions.DEFAULT) ;
			String message = response.toString();
			log.info(message);
			client.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
