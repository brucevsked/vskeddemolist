package com.vsked.common;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
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
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> tourData(String xml)throws Exception{
		Map<String, Object> tourMap=new LinkedHashMap<String, Object>();
		Document doc = DocumentHelper.parseText(xml);
		Element tourEl = doc.getRootElement();
//		System.out.println("节点名称"+tourEl.getName());
		tourMap.put("_nodeName", tourEl.getName());
		List<Attribute> listAttr=tourEl.attributes();//当前节点的所有属性的list
		for(Attribute attr:listAttr){//遍历当前节点的所有属性
			String name=attr.getName();//属性名称
			String value=attr.getValue();//属性的值
			tourMap.put(name, value);
		}
		
		
		List<Map<String, Object>> panoramaList=new LinkedList<Map<String,Object>>();
		List<Element> panoramaElList=tourEl.elements();
		for(Element  panoramaEl:panoramaElList){
			Map<String, Object> panormaMap=new LinkedHashMap<String, Object>();
			panormaMap.put("_nodeName", panoramaEl.getName());
			
			List<Attribute> panormaAttrList=panoramaEl.attributes();//当前节点的所有属性的list
			for(Attribute panormaAttr:panormaAttrList){//遍历当前节点的所有属性
				String panormaAttrName=panormaAttr.getName();//属性名称
				String panormaAttrValue=panormaAttr.getValue();//属性的值
				panormaMap.put(panormaAttrName, panormaAttrValue);
			}
			
//			System.out.println(panormaMap);
			
			List<Element> level3ElList=panoramaEl.elements();
			List<Map<String, Object>> level3List=new LinkedList<Map<String,Object>>();
			for(Element  level3El:level3ElList){
				Map<String, Object> level3Map=new LinkedHashMap<String, Object>();
				level3Map.put("_nodeName", level3El.getName());
				
				List<Attribute> level3AttrList=level3El.attributes();//当前节点的所有属性的list
				for(Attribute level3Attr:level3AttrList){//遍历当前节点的所有属性
					String level3AttrName=level3Attr.getName();//属性名称
					String level3AttrValue=level3Attr.getValue();//属性的值
					level3Map.put(level3AttrName, level3AttrValue);
				}
				
				List<Element> level4ElList=level3El.elements();
				List<Map<String, Object>> level4List=new LinkedList<Map<String,Object>>();
				for(Element  level4El:level4ElList){
					Map<String, Object> level4Map=new LinkedHashMap<String, Object>();
					level4Map.put("_nodeName", level4El.getName());
//					System.out.println(level4Map);
					List<Attribute> level4AttrList=level4El.attributes();//当前节点的所有属性的list
					for(Attribute level4Attr:level4AttrList){//遍历当前节点的所有属性
						String level4AttrName=level4Attr.getName();//属性名称
						String level4AttrValue=level4Attr.getValue();//属性的值
						level4Map.put(level4AttrName, level4AttrValue);
					}
					level4List.add(level4Map);
				}
				level3Map.put("_subNode", level4List);
				
//				System.out.println(level3Map);
				level3List.add(level3Map);
			}
			panormaMap.put("_subNode", level3List);
			
			panoramaList.add(panormaMap);
			
		}
		
		tourMap.put("_subNode", panoramaList);
		
//		System.out.println(tourMap);
		return tourMap;
	}
	
	public static void main(String[] args) throws Exception {
		String pathname="e:/pano.xml";
		String xml=FileUtils.readFileToString(new File(pathname),"utf-8");
		Map<String, Object> tourMap=StringTools.tourData(xml);
		Iterator<Map.Entry<String, Object>> tourIt=tourMap.entrySet().iterator();
		while(tourIt.hasNext()){
			Map.Entry<String, Object> tourEntry = tourIt.next(); 
			if(tourEntry.getKey().equals("_nodeName")){
			System.out.println("第1层名称Key = " + tourEntry.getKey() + ", Value = " + tourEntry.getValue()); 
			}
			else if(tourEntry.getKey().equals("_subNode")){
				System.out.println("第1层子节点");
				List<Map<String, Object>> panoramaList=(List<Map<String, Object>>) tourEntry.getValue();
				for(Map<String, Object> panormaMap:panoramaList){
					System.out.println("第2层");
					System.out.println(panormaMap);
					Iterator<Map.Entry<String, Object>> panormaIt=panormaMap.entrySet().iterator();
					while(panormaIt.hasNext()){
						Map.Entry<String, Object> panormaEntry = panormaIt.next(); 
						if(panormaEntry.getKey().equals("_nodeName")){
						System.out.println("第2层名称Key = " + panormaEntry.getKey() + ", Value = " + panormaEntry.getValue()); 
						}
						else if(panormaEntry.getKey().equals("_subNode")){
							System.out.println("第2层子节点");
							List<Map<String, Object>> level3List=(List<Map<String, Object>>) panormaEntry.getValue();
							for(Map<String, Object> levelMap:level3List){
								System.out.println("第3层");
								System.out.println(levelMap);
								Iterator<Map.Entry<String, Object>> level3It=levelMap.entrySet().iterator();
								while(level3It.hasNext()){
									Map.Entry<String, Object> level3Entry = level3It.next();
									if(level3Entry.getKey().equals("_nodeName")){
										System.out.println("第3层名称Key = " + level3Entry.getKey() + ", Value = " + level3Entry.getValue()); 
										}
										else if(level3Entry.getKey().equals("_subNode")){
											System.out.println("第3层子节点");
											List<Map<String, Object>> level4List=(List<Map<String, Object>>) level3Entry.getValue();
											for(Map<String, Object> level4Map:level4List){
												System.out.println("第4层");
												System.out.println(level4Map);
											}
										}else{
											System.out.println("第3层其他属性Key = " + level3Entry.getKey() + ", Value = " + level3Entry.getValue()); 
										}
								}//end while
							}
						}else{
							System.out.println("第2层其他属性Key = " + panormaEntry.getKey() + ", Value = " + panormaEntry.getValue()); 
						}
					}//end while
				}
			}else{
				System.out.println("第1层其他属性Key = " + tourEntry.getKey() + ", Value = " + tourEntry.getValue()); 
			}
			
		}//end while
		
	}
	
}
