package com.vsked.common;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlTools {
	ObjectMapper xmlMapper = new XmlMapper();
	
	//https://github.com/FasterXML/jackson-dataformat-xml
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> xmlToMap1(String xmlData) throws Exception{
		return xmlMapper.readValue(xmlData, Map.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> xmlToList1(String xmlData) throws Exception{
		return xmlMapper.readValue(xmlData, List.class);
	}

}
