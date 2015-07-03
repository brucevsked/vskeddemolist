package com.vsked.test;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TestItext {

	public static void main(String[] args) throws Exception {
		
		TestItext tit=new TestItext();
		
		String fname="c:/t.pdf";
		String inTitle="文档的标题就是这个";
		BaseFont bfChinese=BaseFont.createFont("STSong-Light","UniGB-UCS2-H",false);
		Font inputFont=new Font(bfChinese,12,Font.NORMAL);
		
		File f=new File(fname);
		Document d=new Document();
		d.setPageSize(PageSize.A4);
		
		FileOutputStream fos=new FileOutputStream(f);
		PdfWriter.getInstance(d, fos);
		d.open();
		
		d.add(tit.addContent(inTitle, inputFont));
		d.add(tit.addContent("  ", inputFont));
		
		PdfPTable ppt=new PdfPTable(4);
		
		ppt.addCell(tit.getCell("a1天天", inputFont));
		ppt.addCell(tit.getCell("a1开心", inputFont));
		ppt.addCell(tit.getCell("a1只有", inputFont));
		ppt.addCell(tit.getCell("a1看得到", inputFont));
		
		ppt.addCell(tit.getCell("中文使用", inputFont));
		ppt.addCell(tit.getCell("天下第一", inputFont));
		ppt.addCell(tit.getCell("使用人员", inputFont));
		ppt.addCell(tit.getCell("组织机构", inputFont));
		
		d.add(ppt);
		d.close();
		fos.close();
		System.out.println("输出pdf完成,文件名:"+fname);
	}
	
	public PdfPCell getCell(String inputText,Font inputFont){
		PdfPCell ppc=new PdfPCell();
		ppc.setPhrase(new Phrase(inputText, inputFont));
		return ppc;
	}
	
	public Paragraph addContent(String inContent,Font inFont){
		Paragraph p=new Paragraph(inContent,inFont);
		p.setAlignment(Element.ALIGN_CENTER);
		return p;
	}

}
