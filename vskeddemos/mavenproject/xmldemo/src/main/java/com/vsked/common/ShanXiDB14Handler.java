package com.vsked.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ShanXiDB14Handler extends DefaultHandler{
	
	private List<Map<String,Object>> dataList=new LinkedList<Map<String,Object>>();
	private List<Map<String,Object>> dataPointList=new LinkedList<Map<String,Object>>();
	private Map<String,Object> curDataMap=new HashMap<String, Object>();
	private Map<String,Object> curDataPointMap=new HashMap<String, Object>();
	private String preTag = null;//作用是记录解析时的上一个节点名称

    @Override
    public InputSource resolveEntity(String publicId, String systemId)
            throws IOException, SAXException {
        return super.resolveEntity(publicId, systemId);
    }

    @Override
    public void notationDecl(String name, String publicId, String systemId)
            throws SAXException {
        super.notationDecl(name, publicId, systemId);
    }

    @Override
    public void unparsedEntityDecl(String name, String publicId,
            String systemId, String notationName) throws SAXException {
        super.unparsedEntityDecl(name, publicId, systemId, notationName);
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        super.setDocumentLocator(locator);
    }

    @Override
    public void startDocument() throws SAXException {
        //System.err.println("开始解析文档");
        dataList=new LinkedList<Map<String,Object>>();
    }

    @Override
    public void endDocument() throws SAXException {
       // System.err.println("解析结束");
    }

    @Override
    public void startPrefixMapping(String prefix, String uri)
            throws SAXException {
        super.startPrefixMapping(prefix, uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        super.endPrefixMapping(prefix);
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        //System.err.print(localName+"|"+uri+"Element: " + qName + ", attr: ");
        preTag=qName;
        if(qName.toLowerCase().equals("root")){
        	curDataMap=new HashMap<String, Object>();
            for (int i = 0; i < attributes.getLength(); i++) {
                curDataMap.put(attributes.getQName(i), attributes.getValue(i));
            }
            dataList.add(curDataMap);//直接放进去
            
        } else if(qName.toLowerCase().equals("head")){
        	curDataMap=new HashMap<String, Object>();
            for (int i = 0; i < attributes.getLength(); i++) {
                curDataMap.put(attributes.getQName(i), attributes.getValue(i));
            }
            
        } else if(qName.toLowerCase().equals("data")){
        	curDataMap=new HashMap<String, Object>();
            for (int i = 0; i < attributes.getLength(); i++) {
                curDataMap.put(attributes.getQName(i), attributes.getValue(i));
            }
            dataPointList=new LinkedList<Map<String,Object>>();            
        }else if(qName.toLowerCase().equals("point")){
        	curDataPointMap=new HashMap<String, Object>();
            for (int i = 0; i < attributes.getLength(); i++) {
            	curDataPointMap.put(attributes.getQName(i), attributes.getValue(i));
            }
        }
        //print(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
    	if(!qName.toLowerCase().equals("point")){
    		dataList.add(curDataMap);
    	}
    	if(qName.toLowerCase().equals("point")){
    		dataPointList.add(curDataPointMap);
    		curDataMap.put("point", dataPointList);
    	}
    	
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if(preTag!=null){
        	String content = new String(ch,start,length);
        	if(preTag.toLowerCase().equals("data")){
        		//System.out.println(content);
        	}
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length)
            throws SAXException {
        super.ignorableWhitespace(ch, start, length);
    }

    @Override
    public void processingInstruction(String target, String data)
            throws SAXException {
        super.processingInstruction(target, data);
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        super.skippedEntity(name);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        super.fatalError(e);
    }
    
    private void print(Attributes attrs) {
        if (attrs == null) return;
        System.err.print("[");
        for (int i = 0; i < attrs.getLength(); i++) {
            System.err.print(attrs.getQName(i) + " = " + attrs.getValue(i));
            if (i != attrs.getLength() - 1) {
                System.err.print(", ");
            }
        }
        System.err.println("]");
    }
    
    public List<Map<String, Object>> getDataList() {
		return dataList;
	}

	public List<Map<String,Object>> getResult(String testFileBody) throws Exception{
    	InputStream is=new ByteArrayInputStream(testFileBody.getBytes());
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ShanXiDB14Handler myHandler=new ShanXiDB14Handler();
        parser.parse(is, myHandler);
        return myHandler.getDataList();
    }
}
