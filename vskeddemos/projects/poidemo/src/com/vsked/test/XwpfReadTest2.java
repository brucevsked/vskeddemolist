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
	 * 通过XWPFDocument对内容进行访问。对于XWPF文档而言，用这种方式进行读操作更佳。
	 * 
	 * @throws Exception
	 */
	public void testReadByDoc() throws Exception {
		InputStream is = new FileInputStream(SystemUtil.getSystemPath("testw.docx"));
		XWPFDocument doc = new XWPFDocument(is);
		List<XWPFParagraph> paras = doc.getParagraphs();
		for (XWPFParagraph para : paras) {
			// 当前段落的属性
			// CTPPr pr = para.getCTP().getPPr();
			System.out.println(para.getText());
		}
		// 获取文档中所有的表格
		List<XWPFTable> tables = doc.getTables();
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		for (XWPFTable table : tables) {
			// 表格属性
			// CTTblPr pr = table.getCTTbl().getTblPr();
			// 获取表格对应的行
			rows = table.getRows();
			for (XWPFTableRow row : rows) {
				// 获取行对应的单元格
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
	 * 关闭输入流
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
