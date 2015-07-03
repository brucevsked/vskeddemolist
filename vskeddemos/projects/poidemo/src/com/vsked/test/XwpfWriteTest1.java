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
		//�ļ�д��web-info/classes/Ŀ¼��
		XwpfWriteTest1 t=new XwpfWriteTest1();
		t.testSimpleWrite();
		t.testWriteTable();
		System.out.println("write finish");
	}

	/**
	 * ������д����
	 * 
	 * @throws Exception
	 */
	public void testSimpleWrite() throws Exception {
		// �½�һ���ĵ�
		XWPFDocument doc = new XWPFDocument();
		// ����һ������
		XWPFParagraph para = doc.createParagraph();
		XWPFParagraph para1 = doc.createParagraph();

		// һ��XWPFRun���������ͬ���Ե�һ������
		XWPFRun run = para.createRun();
		run.setBold(true); // �Ӵ�
		run.setText("�Ӵֵ�����");
		run = para.createRun();
		run.setColor("FF0000");
		run.setText("��ɫ���֡�");
		
		// һ��XWPFRun���������ͬ���Ե�һ������
	    XWPFRun runa = para1.createRun();
		runa.setBold(true); // �Ӵ�
		runa.setText("�Ӵֵ�����");
		runa = para1.createRun();
		runa.setText("��ɫ���֡�");
		OutputStream os = new FileOutputStream(SystemUtil.getSystemPath("testw111notable.docx"));
		// ��doc����������
		doc.write(os);
		this.close(os);
	}

	/***
	 * дһ�����
	 * 
	 * @throws Exception
	 */
	public void testWriteTable() throws Exception {
		XWPFDocument doc = new XWPFDocument();
		// ����һ��5��5�еı��
		XWPFTable table = doc.createTable(5, 5);
		// �������ӵ���ԭ����ʼ����������5����ͨ��getTableCells()������ȡʱ��ȡ��������ͨ��row�����ľͿ��ԡ�
		// table.addNewCol(); //���������һ�У����6��
		table.createRow(); // ���������һ�У����6��
		List<XWPFTableRow> rows = table.getRows();
		// �������
		CTTblPr tablePr = table.getCTTbl().addNewTblPr();
		// �����
		CTTblWidth width = tablePr.addNewTblW();
		width.setW(BigInteger.valueOf(8000));
		XWPFTableRow row;
		List<XWPFTableCell> cells;
		XWPFTableCell cell;
		int rowSize = rows.size();
		int cellSize;
		for (int i = 0; i < rowSize; i++) {
			row = rows.get(i);
			// ������Ԫ��
			row.addNewTableCell();
			// �����еĸ߶�
			row.setHeight(500);
			// ������
			// CTTrPr rowPr = row.getCtRow().addNewTrPr();
			// ���ַ�ʽ�ǿ��Ի�ȡ��������cell�ġ�
			// List<CTTc> list = row.getCtRow().getTcList();
			cells = row.getTableCells();
			cellSize = cells.size();
			for (int j = 0; j < cellSize; j++) {
				cell = cells.get(j);
				if ((i + j) % 2 == 0) {
					// ���õ�Ԫ�����ɫ
					cell.setColor("ff0000"); // ��ɫ
				} else {
					cell.setColor("0000ff"); // ��ɫ
				}
				// ��Ԫ������
				CTTcPr cellPr = cell.getCTTc().addNewTcPr();
				cellPr.addNewVAlign().setVal(STVerticalJc.CENTER);
				if (j == 3) {
					// ���ÿ��
					cellPr.addNewTcW().setW(BigInteger.valueOf(3000));
				}
				cell.setText(i + ", " + j);
			}
		}
		// �ļ�������ʱ���Զ�����
		OutputStream os = new FileOutputStream(SystemUtil.getSystemPath("testw111withtable.docx"));
		// д���ļ�
		doc.write(os);
		this.close(os);
	}

	/**
	 * �ر������
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
