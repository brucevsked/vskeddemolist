package com.vsked.test.dom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * dom读写xml
 */
public class TestDom2 {
	
	public static void main(String[] args) {
		read();
	}
	
	public static void read() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			InputStream in = TestDom2.class.getClassLoader().getResourceAsStream("t1.xml");
			Document doc = builder.parse(in);
			// root <university>
			Element root = doc.getDocumentElement();
			if (root == null) return;
//			System.err.println(root.getAttribute("name"));
			// all college node
			NodeList collegeNodes = root.getChildNodes();
			if (collegeNodes == null) return;
			System.err.println("university子节点数：" + collegeNodes.getLength());
			System.err.println("子节点如下：");
			for(int i = 0; i < collegeNodes.getLength(); i++) {
				Node college = collegeNodes.item(i);
				if (college == null) continue;
				if (college.getNodeType() == Node.ELEMENT_NODE) {
					System.err.println("\t元素节点：" + college.getNodeName());
				} else if (college.getNodeType() == Node.TEXT_NODE) {
					System.err.println("\t文本节点：" + Arrays.toString(college.getTextContent().getBytes()));
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
