package com.vsked.test.stax;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class TestSTAX {

	public static void main(String[] args) throws Exception {
//		read();
		write();
	}

	public static void read() throws Exception {
		InputStream in = TestSTAX.class.getClassLoader().getResourceAsStream(
				"t1.xml");
		XMLInputFactory xif = XMLInputFactory.newInstance();// 创建StAX分析工厂
		XMLStreamReader reader = xif.createXMLStreamReader(in);// 创建分析器
		while (reader.hasNext()) {
			int event = reader.next();// 读取下一个事件
			if (event == XMLStreamReader.START_ELEMENT) {
				System.out.print(reader.getLocalName() + " : ");
				System.out.println(reader.getAttributeCount());
				for (int i = 0; i < reader.getAttributeCount(); i++) {
					System.out.print(reader.getAttributeLocalName(i) + "|"+ reader.getAttributeValue(i) + "|");
				}
			}
		}
	}
	
	public static void write() throws Exception{
		FileOutputStream outFile=new FileOutputStream("c:/vv.xml");
		XMLOutputFactory xof = XMLOutputFactory.newInstance();//创建输出工厂 
		XMLStreamWriter writer = xof.createXMLStreamWriter(outFile,"UTF-8");//创建XML写出流
		writer.setPrefix("", "");//没提供特殊的前缀
		writer.writeStartDocument("UTF-8", "1.0");//开始写文档
	      
	       writer.writeStartElement("", "students");//写出一些内容
	           writer.writeStartElement("student");
	              writer.writeStartElement("student_id");
	                  writer.writeCharacters("S09080709");
	              writer.writeEndElement();
	              writer.writeStartElement("student_name");
	                  writer.writeCharacters("mary");
	              writer.writeEndElement();
	           writer.writeEndElement();
	           writer.writeStartElement("student");
	           writer.writeStartElement("student_id");
	              writer.writeCharacters("S0900121");
	           writer.writeEndElement();
	           writer.writeStartElement("student_name");
	              writer.writeCharacters("Lord");
	           writer.writeEndElement();
	       writer.writeEndElement();
	       writer.writeEndElement();         
	       writer.writeEndDocument();//文档写出结束
	       writer.flush();//刷新缓冲
	       writer.close();//关闭写出流
	       outFile.close();
	}

}
