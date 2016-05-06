package com.vsked.test.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class TestReadFromString {

	public static void main(String[] args) throws Exception {
//		testReadFromString1();
		testReadFromString2();

	}
	
	public static void testReadFromString1(){
		String xmlData="";
		xmlData+="<root>";
		xmlData+="<house>";
		xmlData+="<door>hello door</door>";
		xmlData+="</house>";
		xmlData+="";
		xmlData+="";
		xmlData+="<info>this is myinfo</info>";
		xmlData+="</root>";
		
		System.out.println(readXmlA1(xmlData));
	}
	
	public static void testReadFromString2() throws Exception{
		String xmlData="";
		xmlData+="<productList>";
		for(int i=0;i<10;i++){
		xmlData+="<product>";
		xmlData+="<productName>p"+i+"</productName>";
		xmlData+="<productCode>c"+i+"</productCode>";
		xmlData+="</product>";
		}
		xmlData+="</productList>";
		System.out.println(getSomeData(xmlData));
	}
	
	public static Map<String, String> readXmlA1(String xml) {
		Document doc = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点
			String info = rootElt.elementTextTrim("info");
			Element recordEle1 = rootElt.element("house");
			String door = recordEle1.elementTextTrim("door");
			map.put("info", info);
			map.put("door", door);
			String window = rootElt.elementTextTrim("window");
			map.put("window", window);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static Map<String,String> getSomeData(String xml) throws Exception{
		Map<String, String> rm=new HashMap<String, String>();
		Document doc = DocumentHelper.parseText(xml);
		Element rootElt = doc.getRootElement(); 
		Iterator<?> it = rootElt.elementIterator();
		while (it.hasNext()) {
			Element recordEle = (Element) it.next();
			System.out.println(recordEle);
			
		}
		
		return rm;
	}

}
