package jsoupdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * 参考
 * https://www.cnblogs.com/jycboy/p/jsoupdoc.html
 * 
 * @author brucevsked
 *
 */
public class JsoupTes {
	
	private static final Logger log = LoggerFactory.getLogger(JsoupTes.class);
	
//	@Test
	public void t1(){
		//解析和遍历一个HTML文档
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		log.debug(doc.title());
		log.debug(doc.body().html());
	}
	
	
//	@Test
	public void t2(){
		//解析一个body片断
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p>Parsed HTML into a doc.</p><div><p>Lorem ipsum.</p></div></body></html>";
		Document doc = Jsoup.parseBodyFragment(html);
		Element body = doc.body();
		log.debug(body.childNodes()+"");
		List<Node> nodeList=body.childNodes();
		for(Node myNode:nodeList){
			log.debug(myNode.toString());
		}
	}
	
//	@Test
	public void t3(){
		//从链接加载文档
		try{
		String url1="https://www.aicai.com/pages/lotnew/zq/index_gdhhspf.shtml";
		Document doc = Jsoup.connect(url1).timeout(3000).get();
		String body=doc.body().toString();
		log.debug(body);
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void t4(){
		//从文件加载文档
		try{
		String file1="l:/Users/brucevsked/Desktop/ta.html";
		Document doc = Jsoup.parse(new File(file1), "utf-8");
		String body=doc.body().toString();
		log.debug(body);
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void t5(){
		//使用DOM方法来遍历一个文档
		try{
		String url1="https://www.aicai.com/pages/lotnew/zq/index_gdhhspf.shtml";
		Document doc = Jsoup.connect(url1).timeout(3000).get();
		Element content=doc.getElementById("jq_bet_mainbo");
		Elements links = content.getElementsByTag("a");
		for (Element link : links) {
		  String linkHref = link.attr("href");
		  String linkText = link.text();
		  log.debug(linkHref+"|"+linkText);
		}
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void t6(){
		//使用选择器语法来查找元素
		try{
		String url1="https://www.aicai.com/pages/lotnew/zq/index_gdhhspf.shtml";
		Document doc = Jsoup.connect(url1).timeout(3000).get();
		Elements links = doc.select("a[href]"); //带有href属性的a元素
		log.debug(links.toString());
		Elements pngs = doc.select("img[src$=.png]");//扩展名为.png的图片
		log.debug(pngs.toString());
		Element masthead = doc.select("div.betMainTable").first();//class等于betMainTable的div标签
		log.debug(masthead.toString());
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void t6a(){
		//使用选择器语法来查找元素
		try{
			//解析和遍历一个HTML文档
			String html = "<html><head><title>First parse</title></head>"
					+ "<body><p>Parsed HTML into a doc.</p>";
			html+="<a disabled>首页</a> ";
			html+="<a disabled>上一页</a>&nbsp;";
			html+="<a href=\"result_2.jspx\">下一页</a> ";
//			html+="&nbsp;<a disabled=\"disabled\">下一页</a> ";
			html+="<a href=\"result_2.jspx\">尾页</a>  ";
			html+="</body></html>";
		Document doc = Jsoup.parse(html);
		Element links = doc.select("a:contains(下一页)").first(); //a标签中文本是下一页的抽出来第一个
		log.debug(links.toString());
		log.debug("attr|"+links.attr("href")+"|");
		log.debug("attr|"+"".equals(links.attr("href"))+"|");
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void t7(){
//		从元素抽取属性，文本和HTML
		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现
		Element link = doc.select("a").first();//查找第一个a元素
		 
		String text = doc.body().text(); // "An example link"//取得字符串中的文本
		String linkHref = link.attr("href"); // "http://example.com/"//取得链接地址
		String linkText = link.text(); // "example""//取得链接地址中的文本
		
		log.debug(text);
		log.debug(linkHref);
		log.debug(linkText);
		 
		String linkOuterH = link.outerHtml();   // "<a href="http://example.com"><b>example</b></a>"
		String linkInnerH = link.html(); // "<b>example</b>"//取得链接内的html内容
		log.debug(linkOuterH);
		log.debug(linkInnerH);
	}
	
//	@Test
	public void t8(){
		//设置属性的值
		String html = "<div class=comments>testa<a href=www.baidu.com>baidu</a></div><p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		html+="<div class=masthead >helloword</div>";
		Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现
		doc.select("div.comments a").attr("rel", "nofollow");
		doc.select("div.masthead").attr("title", "jsoup").addClass("round-box");
		log.debug(doc.toString());
	}
	
//	@Test
	public void t9(){
		//设置一个元素的HTML内容
		String html = "<div class=comments>testa<a href=www.baidu.com>baidu</a></div><p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		html+="<div class=masthead >helloword<span><ul><li>1</li><li>2</li></ul></span></div>";
		Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现
		Element div = doc.select("div").first(); // <div></div>
		div.html("<p>lorem ipsum</p>"); // <div><p>lorem ipsum</p></div>
		div.prepend("<p>First</p>");//在div前添加html内容
		div.append("<p>Last</p>");//在div之后添加html内容
		// 添完后的结果: <div><p>First</p><p>lorem ipsum</p><p>Last</p></div>
		 
		Element span = doc.select("span").first(); // <span>One</span>
		span.wrap("<li><a href='http://example.com/'></a></li>");
		// 添完后的结果: <li><a href="http://example.com"><span>One</span></a></li>
		log.debug(doc.toString());
	}
	
//	@Test
	public void t10(){
		//设置元素的文本内容
		String html = "<div class=comments>testa<a href=www.baidu.com>baidu</a></div><p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		html+="<div class=masthead >helloword<span><ul><li>1</li><li>2</li></ul></span></div>";
		Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现
		Element div = doc.select("div").first(); // <div></div>
		div.text("five > four"); // <div>five > four</div>
		div.prepend("First ");
		div.append(" Last");
		// now: <div>First five > four Last</div>
		log.debug(doc.toString());
	}
	
//	@Test
	public void t11(){
		//只取文本
		String html = "<table><tr><td height=\"35\" align=\"center\" bgcolor=\"#FFFFFF\"><span class=\"zhu\">南特</span><span class=\"vs\">VS</span><span class=\"ke\">马赛</span></td></tr></table>";
		Document doc = Jsoup.parse(html);
		Element td = doc.select("td").first(); // <div></div>
		log.debug("|"+td.text()+"|");
	}
	
	
	

}
