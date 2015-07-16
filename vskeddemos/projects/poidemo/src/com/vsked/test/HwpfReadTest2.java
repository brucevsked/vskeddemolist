package com.vsked.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Bookmark;
import org.apache.poi.hwpf.usermodel.Bookmarks;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;

import com.vsked.util.SystemUtil;

public class HwpfReadTest2 {
	public static void main(String[] args) throws Exception {
		new HwpfReadTest2().testReadByDoc();
	}
	
	public void testReadByDoc() throws Exception {
		InputStream is = new FileInputStream(SystemUtil.getSystemPath("testw2003.doc"));
		HWPFDocument doc = new HWPFDocument(is);
		// 输出书签信息
		this.printInfo(doc.getBookmarks());
		// 输出文本
		System.out.println(doc.getDocumentText());
		Range range = doc.getRange();
		// this.insertInfo(range);
		this.printInfo(range);
		// 读表格
		this.readTable(range);
		// 读列表
		this.readList(range);
		// 删除range
		Range r = new Range(2, 5, doc);
		r.delete();// 在内存中进行删除，如果需要保存到文件中需要再把它写回文件
		// 把当前HWPFDocument写到输出流中
		doc.write(new FileOutputStream(SystemUtil.getSystemPath("testw2003Result.doc")));
		this.closeStream(is);
	}

	/**
	 * 关闭输入流
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

	/**
	 * 输出书签信息
	 * 
	 * @param bookmarks
	 */
	private void printInfo(Bookmarks bookmarks) {
		int count = bookmarks.getBookmarksCount();
		System.out.println("书签数量：" + count);
		Bookmark bookmark;
		for (int i = 0; i < count; i++) {
			bookmark = bookmarks.getBookmark(i);
			System.out.println("书签" + (i + 1) + "的名称是：" + bookmark.getName());
			System.out.println("开始位置：" + bookmark.getStart());
			System.out.println("结束位置：" + bookmark.getEnd());
		}
	}

	/**
	 * 读表格 每一个回车符代表一个段落，所以对于表格而言，每一个单元格至少包含一个段落，每行结束都是一个段落。
	 * 
	 * @param range
	 */
	private void readTable(Range range) {
		// 遍历range范围内的table。
		TableIterator tableIter = new TableIterator(range);
		Table table;
		TableRow row;
		TableCell cell;
		while (tableIter.hasNext()) {
			table = tableIter.next();
			int rowNum = table.numRows();
			for (int j = 0; j < rowNum; j++) {
				row = table.getRow(j);
				int cellNum = row.numCells();
				for (int k = 0; k < cellNum; k++) {
					cell = row.getCell(k);
					// 输出单元格的文本
					System.out.println(cell.text().trim());
				}
			}
		}
	}

	/**
	 * 读列表
	 * 
	 * @param range
	 */
	private void readList(Range range) {
		int num = range.numParagraphs();
		Paragraph para;
		for (int i = 0; i < num; i++) {
			para = range.getParagraph(i);
			if (para.isInList()) {
				System.out.println("list: " + para.text());
			}
		}
	}

	/**
	 * 输出Range
	 * 
	 * @param range
	 */
	private void printInfo(Range range) {
		// 获取段落数
		int paraNum = range.numParagraphs();
		System.out.println(paraNum);
		for (int i = 0; i < paraNum; i++) {
			// this.insertInfo(range.getParagraph(i));
			System.out.println("段落" + (i + 1) + "："
					+ range.getParagraph(i).text());
			if (i == (paraNum - 1)) {
				this.insertInfo(range.getParagraph(i));
			}
		}
		int secNum = range.numSections();
		System.out.println(secNum);
		Section section;
		for (int i = 0; i < secNum; i++) {
			section = range.getSection(i);
			System.out.println(section.getMarginLeft());
			System.out.println(section.getMarginRight());
			System.out.println(section.getMarginTop());
			System.out.println(section.getMarginBottom());
			System.out.println(section.getPageHeight());
			System.out.println(section.text());
		}
	}

	/**
	 * 插入内容到Range，这里只会写到内存中
	 * 
	 * @param range
	 */
	private void insertInfo(Range range) {
		range.insertAfter("Hello");
	}
}
