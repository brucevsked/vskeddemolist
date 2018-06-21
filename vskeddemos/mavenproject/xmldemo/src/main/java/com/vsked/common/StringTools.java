package com.vsked.common;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class StringTools {
	
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

}
