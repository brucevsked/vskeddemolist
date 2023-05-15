package com.vsked;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.testng.annotations.Test;

public class HttpUnitTest {
	
	private static final Logger log = LoggerFactory.getLogger(HttpUnitTest.class);
	
	@Test
	public void test1(){
		//抓取带ajax请求的网页
		try{
		 /**HtmlUnit请求web页面*/  
        WebClient wc = new WebClient(BrowserVersion.CHROME);  
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(true); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setTimeout(20000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待 
        
        wc.setAjaxController(new NicelyResynchronizingAjaxController());//设置支持AJAX
        wc.waitForBackgroundJavaScript(30 * 1000); /* will wait JavaScript to execute up to 30s */
        wc.waitForBackgroundJavaScriptStartingBefore(30*1000);
        
        HtmlPage page = wc.getPage("http://info.sporttery.cn/football/hhad_list.php");
        
        //抓取ajax载入数据，此法有效，且强大
        for(int i=0;i<20;i++){
        	log.debug(i+"|"+page.getElementById("mainTbl").getFirstChild());
        	if(page.getElementById("mainTbl").getFirstChild()!=null){
        		break;
        	}
//        	log.debug(i+"|"+page.getElementById("mainTbl").getFirstChild().asXml());
        	synchronized(page){
        		page.wait(1000);
        	}
        }
        
        String pageXml = page.asXml(); //以xml的形式获取响应文本 
        
  
        /**jsoup解析文档*/  
        Document doc = Jsoup.parse(pageXml);   
        Element pv = doc.getElementById("mainTbl");
        log.debug(pv.html());
        wc.close();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}
