package com.vsked.test;

import com.vsked.util.SystemUtil;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class XwpfReadTest1 {
	
	public static void main(String[] args) throws Exception {
		new XwpfReadTest1().testReadByExtractor();
		System.out.println("read finish");
	}
	 
	   /**
	    * ͨ��XWPFWordExtractor����XWPFDocument������
	    * @throws Exception
	    */
	   public void testReadByExtractor() throws Exception {
	      InputStream is = new FileInputStream(SystemUtil.getSystemPath("testw.docx"));
	      XWPFDocument doc = new XWPFDocument(is);
	      XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
	      String text = extractor.getText();
	      System.out.println(text);
	      CoreProperties coreProps = extractor.getCoreProperties();
	      this.printCoreProperties(coreProps);
	      this.close(is);
	   }
	  
	   /**
	    * ���CoreProperties��Ϣ
	    * @param coreProps
	    */
	   private void printCoreProperties(CoreProperties coreProps) {
	      System.out.println(coreProps.getCategory());   //����
	      System.out.println(coreProps.getCreator()); //������
	      System.out.println(coreProps.getCreated()); //����ʱ��
	      System.out.println(coreProps.getTitle());   //����
	   }
	  
	   /**
	    * �ر�������
	    * @param is
	    */
	   private void close(InputStream is) {
	      if (is != null) {
	         try {
	            is.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	   }
	  
	}
