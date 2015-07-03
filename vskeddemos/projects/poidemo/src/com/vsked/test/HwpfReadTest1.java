package com.vsked.test;

import com.vsked.util.SystemUtil;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Range;

public class HwpfReadTest1 {

	public static void main(String[] args) throws Exception {
		HwpfReadTest1 t=new HwpfReadTest1();
		t.testReadByExtractor();
	}

	public void testReadByExtractor() throws Exception {
		InputStream is = new FileInputStream(SystemUtil.getSystemPath("testw2003.doc"));
		WordExtractor extractor = new WordExtractor(is);
		// ���word�ĵ����е��ı�
		System.out.println(extractor.getText());
		System.out.println(extractor.getTextFromPieces());
		// �����ǰword�ĵ���Ԫ������Ϣ���������ߡ��ĵ����޸�ʱ��ȡ�
		System.out.println(extractor.getMetadataTextExtractor().getText());
		// ��ȡ����������ı�
		String paraTexts[] = extractor.getParagraphText();
		for (int i = 0; i < paraTexts.length; i++) {
			System.out.println("Paragraph " + (i + 1) + " : " + paraTexts[i]);
		}
		// �����ǰword��һЩ��Ϣ
		printInfo(extractor.getSummaryInformation());
		// �����ǰword��һЩ��Ϣ
		this.printInfo(extractor.getDocSummaryInformation());
		this.closeStream(is);
	}

	/**
	 * ���SummaryInfomation
	 * 
	 * @param info
	 */
	private void printInfo(SummaryInformation info) {
		// ����
		System.out.println(info.getAuthor());
		// �ַ�ͳ��
		System.out.println(info.getCharCount());
		// ҳ��
		System.out.println(info.getPageCount());
		// ����
		System.out.println(info.getTitle());
		// ����
		System.out.println(info.getSubject());
	}

	/**
	 * ���DocumentSummaryInfomation
	 * 
	 * @param info
	 */
	private void printInfo(DocumentSummaryInformation info) {
		// ����
		System.out.println(info.getCategory());
		// ��˾
		System.out.println(info.getCompany());
	}

	/**
	 * �ر�������
	 * 
	 * @param is
	 */
	private void closeStream(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
