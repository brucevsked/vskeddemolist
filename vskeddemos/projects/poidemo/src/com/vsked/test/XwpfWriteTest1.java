package com.vsked.test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

import com.vsked.util.SystemUtil;

public class XwpfWriteTest1 {
	
	public static void main(String[] args) throws Exception {
		//文件写在web-info/classes/目录下
		XwpfWriteTest1 t=new XwpfWriteTest1();
		t.testSimpleWrite();
		t.testWriteTable();
		System.out.println("write finish");
	}

	/**
	 * 基本的写操作
	 * 
	 * @throws Exception
	 */
	public void testSimpleWrite() throws Exception {
		// 新建一个文档
		XWPFDocument doc = new XWPFDocument();
		// 创建一个段落
		XWPFParagraph para = doc.createParagraph();
		XWPFParagraph para1 = doc.createParagraph();

		// 一个XWPFRun代表具有相同属性的一个区域。
		XWPFRun run = para.createRun();
		run.setBold(true); // 加粗
		run.setText("加粗的内容");
		run = para.createRun();
		run.setColor("FF0000");
		run.setText("红色的字。");
		
		// 一个XWPFRun代表具有相同属性的一个区域。
	    XWPFRun runa = para1.createRun();
		runa.setBold(true); // 加粗
		runa.setText("加粗的内容");
		runa = para1.createRun();
		runa.setText("红色的字。");
		OutputStream os = new FileOutputStream(SystemUtil.getSystemPath("testw111notable.docx"));
		// 把doc输出到输出流
		doc.write(os);
		this.close(os);
	}

	/***
	 * 写一个表格
	 * 
	 * @throws Exception
	 */
	public void testWriteTable() throws Exception {
		XWPFDocument doc = new XWPFDocument();
		// 创建一个5行5列的表格
		XWPFTable table = doc.createTable(5, 5);
		// 这里增加的列原本初始化创建的那5行在通过getTableCells()方法获取时获取不到，但通过row新增的就可以。
		// table.addNewCol(); //给表格增加一列，变成6列
		table.createRow(); // 给表格新增一行，变成6行
		List<XWPFTableRow> rows = table.getRows();
		// 表格属性
		CTTblPr tablePr = table.getCTTbl().addNewTblPr();
		// 表格宽度
		CTTblWidth width = tablePr.addNewTblW();
		width.setW(BigInteger.valueOf(8000));
		XWPFTableRow row;
		List<XWPFTableCell> cells;
		XWPFTableCell cell;
		int rowSize = rows.size();
		int cellSize;
		for (int i = 0; i < rowSize; i++) {
			row = rows.get(i);
			// 新增单元格
			row.addNewTableCell();
			// 设置行的高度
			row.setHeight(500);
			// 行属性
			// CTTrPr rowPr = row.getCtRow().addNewTrPr();
			// 这种方式是可以获取到新增的cell的。
			// List<CTTc> list = row.getCtRow().getTcList();
			cells = row.getTableCells();
			cellSize = cells.size();
			for (int j = 0; j < cellSize; j++) {
				cell = cells.get(j);
				if ((i + j) % 2 == 0) {
					// 设置单元格的颜色
					cell.setColor("ff0000"); // 红色
				} else {
					cell.setColor("0000ff"); // 蓝色
				}
				// 单元格属性
				CTTcPr cellPr = cell.getCTTc().addNewTcPr();
				cellPr.addNewVAlign().setVal(STVerticalJc.CENTER);
				if (j == 3) {
					// 设置宽度
					cellPr.addNewTcW().setW(BigInteger.valueOf(3000));
				}
				cell.setText(i + ", " + j);
			}
		}
		// 文件不存在时会自动创建
		OutputStream os = new FileOutputStream(SystemUtil.getSystemPath("testw111withtable.docx"));
		// 写入文件
		doc.write(os);
		this.close(os);
	}

	/**
	 * 关闭输出流
	 * 
	 * @param os
	 */
	private void close(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
