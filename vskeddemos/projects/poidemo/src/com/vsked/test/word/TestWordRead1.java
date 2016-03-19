package com.vsked.test.word;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.vsked.util.SystemUtil;

public class TestWordRead1 {

	public static void main(String[] args) throws Exception {
		
		new TestWordRead1().testReadByExtractor();
	}

	public void testReadByExtractor() throws Exception {
		InputStream is = new FileInputStream(SystemUtil.getSystemPath("testw.docx"));
		XWPFDocument doc = new XWPFDocument(is);
		XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
		String text = extractor.getText();
		System.out.println(text);
		System.out.println("----------------");
		//System.out.println(text.replace("\n", ""));
		CoreProperties coreProps = extractor.getCoreProperties();
		this.printCoreProperties(coreProps);
		this.close(is);
	}

	private void printCoreProperties(CoreProperties coreProps) {
		System.out.println(coreProps.getCategory()); // 分类
		System.out.println(coreProps.getCreator()); // 创建者
		System.out.println(coreProps.getCreated()); // 创建时间
		System.out.println(coreProps.getTitle()); // 标题
	}

	private void close(InputStream is) {
		if (is != null) {
			try { is.close();
			} catch (Exception e) { e.printStackTrace(); }
		}
	}

}
