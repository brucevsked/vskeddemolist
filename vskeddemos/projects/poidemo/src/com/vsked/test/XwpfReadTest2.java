package com.vsked.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.vsked.util.SystemUtil;

public class XwpfReadTest2 {
	public static void main(String[] args) throws Exception {
		new XwpfReadTest2().testReadByDoc();
		System.out.println("read finish");
	}

	/**
	 * ͨ��XWPFDocument�����ݽ��з��ʡ�����XWPF�ĵ����ԣ������ַ�ʽ���ж��������ѡ�
	 * 
	 * @throws Exception
	 */
	public void testReadByDoc() throws Exception {
		InputStream is = new FileInputStream(SystemUtil.getSystemPath("testw.docx"));
		XWPFDocument doc = new XWPFDocument(is);
		List<XWPFParagraph> paras = doc.getParagraphs();
		for (XWPFParagraph para : paras) {
			// ��ǰ���������
			// CTPPr pr = para.getCTP().getPPr();
			System.out.println(para.getText());
		}
		// ��ȡ�ĵ������еı��
		List<XWPFTable> tables = doc.getTables();
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		for (XWPFTable table : tables) {
			// �������
			// CTTblPr pr = table.getCTTbl().getTblPr();
			// ��ȡ����Ӧ����
			rows = table.getRows();
			for (XWPFTableRow row : rows) {
				// ��ȡ�ж�Ӧ�ĵ�Ԫ��
				cells = row.getTableCells();
				for (XWPFTableCell cell : cells) {
					System.out.println(cell.getText());
					;
				}
			}
		}
		this.close(is);
	}

	/**
	 * �ر�������
	 * 
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
