package com.vsked.test.dom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * dom读写xml
 */
public class TestDom {
    
    public static void main(String[] args) {
        read();
        //write();
    }
    
    public static void read() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            InputStream in = TestDom.class.getClassLoader().getResourceAsStream("t1.xml");
            Document doc = builder.parse(in);
            // root <university>
            Element root = doc.getDocumentElement();
            if (root == null) return;
            System.err.println(root.getAttribute("name"));
            // all college node
            NodeList collegeNodes = root.getChildNodes();
            if (collegeNodes == null) return;
            for(int i = 0; i < collegeNodes.getLength(); i++) {
                Node college = collegeNodes.item(i);
                if (college != null && college.getNodeType() == Node.ELEMENT_NODE) {
                    System.err.println("\t" + college.getAttributes().getNamedItem("name").getNodeValue());
                    // all class node
                    NodeList classNodes = college.getChildNodes();
                    if (classNodes == null) continue;
                    for (int j = 0; j < classNodes.getLength(); j++) {
                        Node clazz = classNodes.item(j);
                        if (clazz != null && clazz.getNodeType() == Node.ELEMENT_NODE) {
                            System.err.println("\t\t" + clazz.getAttributes().getNamedItem("name").getNodeValue());
                            // all student node
                            NodeList studentNodes = clazz.getChildNodes();
                            if (studentNodes == null) continue;
                            for (int k = 0; k < studentNodes.getLength(); k++) {
                                Node student = studentNodes.item(k);
                                if (student != null && student.getNodeType() == Node.ELEMENT_NODE) {
                                    System.err.print("\t\t\t" + student.getAttributes().getNamedItem("name").getNodeValue());
                                    System.err.print(" " + student.getAttributes().getNamedItem("sex").getNodeValue());
                                    System.err.println(" " + student.getAttributes().getNamedItem("age").getNodeValue());
                                }
                            }
                        }
                    }
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
    
    public static void write() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            InputStream in = TestDom.class.getClassLoader().getResourceAsStream("test.xml");
            Document doc = builder.parse(in);
            // root <university>
            Element root = doc.getDocumentElement();
            if (root == null) return;
            // 修改属性
            root.setAttribute("name", "tsu");
            NodeList collegeNodes = root.getChildNodes();
            if (collegeNodes != null) {
                for (int i = 0; i <collegeNodes.getLength() - 1; i++) {
                    // 删除节点
                    Node college = collegeNodes.item(i);
                    if (college.getNodeType() == Node.ELEMENT_NODE) {
                        String collegeName = college.getAttributes().getNamedItem("name").getNodeValue();
                        if ("c1".equals(collegeName) || "c2".equals(collegeName)) {
                            root.removeChild(college);
                        } else if ("c3".equals(collegeName)) {
                            Element newChild = doc.createElement("class");
                            newChild.setAttribute("name", "c4");
                            college.appendChild(newChild);
                        }
                    }
                }
            }
            // 新增节点
            Element addCollege = doc.createElement("college");
            addCollege.setAttribute("name", "c5");
            root.appendChild(addCollege);
            Text text = doc.createTextNode("text");
            addCollege.appendChild(text);
            
            // 将修改后的文档保存到文件
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transFormer = transFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            File file = new File("src/dom-modify.xml");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);         
            StreamResult xmlResult = new StreamResult(out);
            transFormer.transform(domSource, xmlResult);
            System.out.println(file.getAbsolutePath());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
