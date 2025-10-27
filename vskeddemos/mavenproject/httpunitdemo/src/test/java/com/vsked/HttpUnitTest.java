package com.vsked;

import org.htmlunit.BrowserVersion;
import org.htmlunit.NicelyResynchronizingAjaxController;
import org.htmlunit.WebClient;
import org.htmlunit.html.DomElement;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.List;


public class HttpUnitTest {
	
	private static final Logger log = LoggerFactory.getLogger(HttpUnitTest.class);
	
	@Test
	public void test1() throws Exception {
		//抓取带ajax请求的网页
		 /**HtmlUnit请求web页面*/  
        WebClient wc = new WebClient(BrowserVersion.CHROME);
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(true); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setTimeout(20000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待

        // 👇 关键：设置更真实的请求头
        wc.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        wc.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        wc.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");
        
        wc.setAjaxController(new NicelyResynchronizingAjaxController());//设置支持AJAX
        
        HtmlPage page = wc.getPage("https://www.baidu.com/");
        // 获取所有 class="chapter-list" 的 <ul> 元素
//        List<HtmlElement> elements = page.getByXPath("//ul[@class='chapter-list']");
//        log.info("{}",elements);
        DomElement elements;
//        //抓取ajax载入数据，此法有效，且强大
        for(int i=0;i<20;i++){
            elements=page.getElementById("wrapper");
        	log.debug(i+"|"+elements);
        	if(elements!=null){
        		break;
        	}
//        	log.debug(i+"|"+page.getElementById("mainTbl").getFirstChild().asXml());
        	synchronized(page){
        		page.wait(3000);
                wc.waitForBackgroundJavaScript(30 * 1000); /* will wait JavaScript to execute up to 30s */
                wc.waitForBackgroundJavaScriptStartingBefore(30*1000);
        	}
        }

        String pageXml = page.asXml(); //以xml的形式获取响应文本
        log.info("{}",pageXml);
//
//
//        /**jsoup解析文档*/
//        Document doc = Jsoup.parse(pageXml);
//        Element pv = doc.getElementById("mainTbl");
//        log.debug(pv.html());
        wc.close();
	}

    @Test
    public void getByClassName() throws Exception {
        //抓取带ajax请求的网页
        /**HtmlUnit请求web页面*/
        WebClient wc = new WebClient(BrowserVersion.CHROME);
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true
        wc.getOptions().setCssEnabled(true); //禁用css支持
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常
        wc.getOptions().setTimeout(20000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待

        // 👇 关键：设置更真实的请求头
        wc.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        wc.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        wc.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");

        wc.setAjaxController(new NicelyResynchronizingAjaxController());//设置支持AJAX


        HtmlPage page = wc.getPage("https://www.baidu.com/");

        wc.waitForBackgroundJavaScript(30 * 1000); /* will wait JavaScript to execute up to 30s */
        wc.waitForBackgroundJavaScriptStartingBefore(30*1000);

        List<HtmlElement> elements = page.getByXPath("//a[@class='mnav c-font-normal c-color-t']");
        for(HtmlElement element:elements){
            log.info(element.getTextContent());
        }

        wc.close();
    }
    
    

}
