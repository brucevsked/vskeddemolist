package com.vsked.util;

import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTextBox;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestSheetTextBox {
	public static void main(String[] args) throws Exception {
		XSSFWorkbook wb = new XSSFWorkbook("c:/002.xlsx");
		XSSFSheet xs=wb.getSheetAt(1);
		XSSFDrawing xd=xs.getDrawingPatriarch();
		List<XSSFShape> shapeList=xd.getShapes();
		Iterator<XSSFShape> it = shapeList.iterator();
		while(it.hasNext()) {           
		    XSSFShape shape = it.next();
		    System.out.println(shape.getDrawing().getCTDrawing());
		    //TODO read excel
		}
		wb.close();

	}

}
