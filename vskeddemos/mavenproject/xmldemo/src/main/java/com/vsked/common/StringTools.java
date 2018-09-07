package com.vsked.common;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class StringTools {
	
	static List<Map<String, String>> xmlDataList=new LinkedList<Map<String,String>>();
	
	
	/**
	 * 转换xml为map dom4j版本
	 * 输入数据
	 * <?xml version="1.0" encoding="UTF-8"?>
	 * <EPOSPROTOCOL>
	 * <RSPCOD>000000</RSPCOD>
	 * <RSPMSG>上传成功</RSPMSG>
	 * <DATA>20180620-1800-c71f8760-1313-48bc-8697-2cf6866d9608</DATA>
	 * </EPOSPROTOCOL>
	 * 输出数据
	 * {RSPCOD=000000, RSPMSG=上传成功, DATA=20180620-1800-c71f8760-1313-48bc-8697-2cf6866d9608}
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> xmlToMap_dom4j(String xml) throws Exception{
		Map<String, Object> resultMap=new LinkedHashMap<String, Object>();
		Document doc = DocumentHelper.parseText(xml);
		Element rootElt = doc.getRootElement(); 
		Iterator<?> it = rootElt.elementIterator();
		while (it.hasNext()) {
			Element recordEle = (Element) it.next();
			resultMap.put(recordEle.getName(), recordEle.getText());
		}
		return resultMap;
	}
	
	public static List<Map<String, String>> xmlToMap_dom4jExt1(String xml) throws Exception{
		xmlDataList=new LinkedList<Map<String,String>>();
		Map<String, Object> resultMap=new LinkedHashMap<String, Object>();
		Document doc = DocumentHelper.parseText(xml);
		Element rootElt = doc.getRootElement(); 
		xmlDataList=getNode(rootElt);
		return xmlDataList;
	}
	
	public static List<Map<String, String>> getNode(Element node){
		Map<String, String> nodeMap=new LinkedHashMap<String, String>();
		nodeMap.put("n1d_"+node.getName(), node.getText());
		List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list
		for(Attribute attr:listAttr){//遍历当前节点的所有属性
			String name=attr.getName();//属性名称
			String value=attr.getValue();//属性的值
			nodeMap.put("a1t_"+name, value);
		}
		xmlDataList.add(nodeMap);
		List<Element> listElement=node.elements();
		for(Element el:listElement){
			getNode(el);
		}
		return xmlDataList;
	}
	
	public static List<Map<String, String>> getNodeExt1(Element node){
		Map<String, String> nodeMap=new LinkedHashMap<String, String>();
		System.out.println("节点名称"+node.getName());
		List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list
		for(Attribute attr:listAttr){//遍历当前节点的所有属性
			String name=attr.getName();//属性名称
			String value=attr.getValue();//属性的值
			System.out.println("属性名称|"+name+"属性值|"+ value);
		}
		System.out.println("-------------------------------------------");
		xmlDataList.add(nodeMap);
		List<Element> listElement=node.elements();
		for(Element el:listElement){
			getNodeExt1(el);
		}
		return xmlDataList;
	}
	
	//顶层
	public static List<Map<String, String>>  xmlToMap_dom4jExt2(String xml) throws Exception{
		List<Map<String, String>> dataList=new LinkedList<Map<String,String>>();
		Document doc = DocumentHelper.parseText(xml);
		Element rootElt = doc.getRootElement(); 
		Iterator<?> it = rootElt.elementIterator();
		while (it.hasNext()) {
			Element recordEle = (Element) it.next();
			System.out.println("节点名称"+recordEle.getName());
			List<Attribute> listAttr=recordEle.attributes();//当前节点的所有属性的list
			for(Attribute attr:listAttr){//遍历当前节点的所有属性
				String name=attr.getName();//属性名称
				String value=attr.getValue();//属性的值
				System.out.println("属性名称|"+name+"属性值|"+ value);
			}
		}
		return dataList;
	}
	
	public static List<Map<String, String>>  xmlToMap_dom4jExt3(String xml) throws Exception{
		xmlDataList=new LinkedList<Map<String,String>>();
		Map<String, Object> resultMap=new LinkedHashMap<String, Object>();
		Document doc = DocumentHelper.parseText(xml);
		Element rootElt = doc.getRootElement(); 
		xmlDataList=getNodeExt1(rootElt);
		return xmlDataList;
	}
	
}
