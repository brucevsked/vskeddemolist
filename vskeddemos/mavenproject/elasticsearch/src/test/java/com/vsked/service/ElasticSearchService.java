package com.vsked.service;

import java.util.concurrent.TimeUnit;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import com.vsked.test.BaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ElasticSearchService extends BaseTest{
	
	@Test
	public void query() {
		try {
		log.info("start query elastic search");
		//构造查询客户端
		RestHighLevelClient highLevelClient = new RestHighLevelClient(
				RestClient.builder(
						new HttpHost("192.168.111.45", 9222, "http")));
		//新建查询请求
		SearchRequest searchRequest = new SearchRequest();
		//设置索引
        searchRequest.indices(".kibana_1");
        //设置索引类型
        searchRequest.types("_doc");
        
        // 查询条件=
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("type", "ui-metric");
        TermQueryBuilder termQuery = QueryBuilders.termQuery("count", "1");
        // 查询范围查询
        RangeQueryBuilder timeFilter = QueryBuilders.rangeQuery("updated_at").gt("2020-01-28").lt("2020-04-01");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //构造查询条件
        QueryBuilder totalFilter = QueryBuilders.boolQuery()
                .filter(matchQuery)
                .filter(timeFilter)
                .mustNot(termQuery);

        int size = 200;
        int from = 0;
        long total = 0;
        
        //绑定查询条件与返回页大小
        sourceBuilder.query(totalFilter).from(from).size(size);
        //设置超时
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        //设置查询条件源
        searchRequest.source(sourceBuilder);
        //设置查询头 默认
        RequestOptions headers = RequestOptions.DEFAULT;
        //通过查询客户端发送查询请求
		SearchResponse response = highLevelClient.search(searchRequest, headers);
		//获取响应结果
        SearchHit[] hits = response.getHits().getHits();
        //输入出命中结果
        for (SearchHit hit : hits) {
        	log.info(hit.getSourceAsString());
        }

        total = response.getHits().totalHits;

        log.info("测试:[" + total + "][" + from + "-" + (from + hits.length) + ")");
        highLevelClient.close();
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
		}
	}

}
