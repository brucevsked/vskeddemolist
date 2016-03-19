package com.vsked.test.word;


import java.io.FileInputStream;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFootnote;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument;

public class TestHwpfCountWords {

	public static void main(String[] args) throws Exception {
		TestHwpfCountWords thcw=new TestHwpfCountWords();
		String filePath="c:/001.docx";
		
		FileInputStream fileInputStream = new FileInputStream(filePath);
		XWPFDocument document = new XWPFDocument(OPCPackage.open(fileInputStream)); 
		int textBoxCount=0;
		for (XWPFParagraph xwpfParagraph : document.getParagraphs()) {
			textBoxCount+=thcw.getCountContentsOfTextBox(xwpfParagraph);
		}
		
		
		
		int wordCountx = document.getProperties().getExtendedProperties().getUnderlyingProperties().getCharactersWithSpaces();
		
		int footNoteCountx=thcw.getCountContentOfFootNote(document);
		System.out.println(wordCountx);
		System.out.println(textBoxCount);
		System.out.println(footNoteCountx);
		
		int allCount=wordCountx+textBoxCount+footNoteCountx;
		System.out.println(allCount);
		
		
		/*
		//no space
		int wordCount1 = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getCharacters();
		//has space
		int wordCount2 = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getCharactersWithSpaces();
		int wordCount3 = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getCharactersWithSpaces();
		
		System.out.println(wordCount1);
		System.out.println(wordCount2);
		System.out.println(wordCount3);
		*/
	}
	private int getCountContentsOfTextBox(XWPFParagraph paragraph) {
        StringBuilder sb=new StringBuilder();
	    XmlObject[] textBoxObjects =  paragraph.getCTP().selectPath(" declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main'  declare namespace wps='http://schemas.microsoft.com/office/word/2010/wordprocessingShape' .//*/wps:txbx/w:txbxContent");

	    for (int i =0; i < textBoxObjects.length; i++) {
	        XWPFParagraph embeddedPara = null;
	        try {
	        XmlObject[] paraObjects = textBoxObjects[i].
	            selectChildren(new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "p"));

	        for (int j=0; j<paraObjects.length; j++) {
	            embeddedPara = new XWPFParagraph(CTP.Factory.parse(paraObjects[j].xmlText()), paragraph.getBody());
	            System.out.println(embeddedPara.getText());
	            sb.append(embeddedPara.getText());
	        } 

	        } catch (XmlException e) {
	        	e.printStackTrace();
	        	System.out.println(1112);
	        //handle
	        }
	    }
	    return sb.toString().length();

	 } 
	
	private int getCountContentOfFootNote(XWPFDocument document){
		StringBuilder sb=new StringBuilder();
        List<XWPFFootnote> flist=document.getFootnotes();
		
		for(XWPFFootnote ft:flist){
			List<XWPFParagraph> xpList=ft.getParagraphs();
			for(XWPFParagraph tp:xpList){
				System.out.println("|"+tp.getText()+"|");
				sb.append(tp.getText());
			}
		}
		return sb.toString().length();
	}
	
}
