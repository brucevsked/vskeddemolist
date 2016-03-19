package com.vsked.test.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import com.vsked.util.SystemUtil;

public class TestWordRead2 {
	
	public static void main(String[] args) throws Exception {
		TestWordRead2 t=new TestWordRead2();
		//t.read2003(SystemUtil.getSystemPath("testw2003.doc"));
		t.read2007(SystemUtil.getSystemPath("testw.docx"));
	}
	
	public void read2003(String fname) throws Exception{
		OPCPackage opcPackage = POIXMLDocument.openPackage(fname);  
        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);  
        String text2003 = extractor.getText();  
        System.out.println(text2003);  
        extractor.close();
        opcPackage.close();
	}
	
	public void read2007(String fname) throws Exception{
		OPCPackage opcPackage = POIXMLDocument.openPackage(fname);  
        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);  
        String text2007 = extractor.getText();  
        System.out.println(text2007);  
        opcPackage.close();
	}

}
