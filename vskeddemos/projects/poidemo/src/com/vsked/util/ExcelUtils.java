package com.vsked.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static Map<String, String[][]> xssfRead(String fname) throws Exception{
		Map<String, String[][]> m=new HashMap<String, String[][]>();
		String[][] sheetData=null;
		OPCPackage pkg = OPCPackage.open(new File(fname));
		XSSFWorkbook wb = new XSSFWorkbook(pkg);
		int sheetCount=wb.getNumberOfSheets();
		for(int sheetIndex=0;sheetIndex<sheetCount;sheetIndex++){
			XSSFSheet sheet=wb.getSheetAt(sheetIndex);
			String sheetName=sheet.getSheetName();
			sheetData=null;
			int rowCount=sheet.getPhysicalNumberOfRows();
			for(int rowIndex=0;rowIndex<rowCount;rowIndex++){
				XSSFRow row=sheet.getRow(rowIndex);
				int columnCount=row==null?0:row.getLastCellNum();

                if(sheetData==null){
                	sheetData= new String[rowCount][columnCount];
                }
                
				for(int columnIndex=0;columnIndex<columnCount;columnIndex++){
					XSSFCell cell=row.getCell(columnIndex);
					//System.out.print("["+rowIndex + ":" + columnIndex + "||"	+ getCellValue(cell)+"]");
					sheetData[rowIndex][columnIndex]=getCellValue(cell);
				}
			}
			m.put(sheetName, sheetData);
		}
		pkg.close();
		return m;
	}
	
	public static Map<String, String[][]> hssfRead(String fname) throws Exception{
		Map<String, String[][]> m=new HashMap<String, String[][]>();
	
		String[][] sheetData=null;
		
		InputStream is=new FileInputStream(fname);
		HSSFWorkbook wb=new HSSFWorkbook(new POIFSFileSystem(is));
		int sheetCount=wb.getNumberOfSheets();
		
		for(int sheetIndex=0;sheetIndex<sheetCount;sheetIndex++){
			HSSFSheet hs=wb.getSheetAt(sheetIndex);
			String sheetName=hs.getSheetName();
			
			sheetData=null;
			int rowCount=hs.getPhysicalNumberOfRows();
			for(int rowIndex=0;rowIndex<rowCount;rowIndex++){
				HSSFRow row=hs.getRow(rowIndex);
				int columnCount=row==null?0:row.getLastCellNum();
				if(sheetData==null){
                	sheetData= new String[rowCount][columnCount];
                }
				for(int columnIndex=0;columnIndex<columnCount;columnIndex++){
					HSSFCell cell=row.getCell(columnIndex);
					//System.out.print("["+rowIndex + ":" + columnIndex + "||"	+ getCellValue(cell)+"]");
					sheetData[rowIndex][columnIndex]=getCellValue(cell);
				}
			}
			m.put(sheetName, sheetData);
		}
		return m;
	}
	
	public static String getCellValue(XSSFCell c){
		String s="";
		if(c==null){
			return s;
		}
		switch(c.getCellType()){
		case XSSFCell.CELL_TYPE_NUMERIC:
			c.setCellType(XSSFCell.CELL_TYPE_STRING);
			s=c.getStringCellValue();
			break;
		case XSSFCell.CELL_TYPE_STRING:
			s=c.getStringCellValue();
			break;
		case XSSFCell.CELL_TYPE_FORMULA:
			try {
				s = String.valueOf(c.getNumericCellValue());
			} catch (IllegalStateException e) {
				s = String.valueOf(c.getRichStringCellValue());
			}
			break;
		case XSSFCell.CELL_TYPE_BLANK:
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN:
			s=String.valueOf(c.getBooleanCellValue());
			break;
		case XSSFCell.CELL_TYPE_ERROR:
			break;
		default:
				s=String.valueOf(c.getRichStringCellValue());
		}
		return s;
	}

	public static String getCellValue(HSSFCell c){
		String s="";
		if(c==null){
			return s;
		}
		switch(c.getCellType()){
		case HSSFCell.CELL_TYPE_NUMERIC:
			c.setCellType(HSSFCell.CELL_TYPE_STRING);
			s=c.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_STRING:
			s=c.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			try {
				s = String.valueOf(c.getNumericCellValue());
			} catch (IllegalStateException e) {
				s = String.valueOf(c.getRichStringCellValue());
			}
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			s=String.valueOf(c.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			break;
		default:
				s=String.valueOf(c.getRichStringCellValue());
		}
		return s;
	}
	
	
	public static void hssfWrite(String fname,Map<String, String[][]> m) throws Exception{
		FileOutputStream fos = new FileOutputStream(fname);
		HSSFWorkbook wb = new HSSFWorkbook();
		for(Map.Entry<String, String[][]> entry:m.entrySet()){
			HSSFSheet sheet=wb.createSheet(entry.getKey());
			String[][] sheetData=entry.getValue();
			for(int rowIndex=0;rowIndex<sheetData.length;rowIndex++){
				HSSFRow row=sheet.createRow(rowIndex);
				for(int columnIndex=0;columnIndex<sheetData[rowIndex].length;columnIndex++){
					HSSFCell cell=row.createCell(columnIndex);
					if(ValidateUtils.isNullOrIsEmpty(sheetData[rowIndex][columnIndex])){
						cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
					}
					if(ValidateUtils.isNumber(sheetData[rowIndex][columnIndex])){
						cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
						cell.setCellValue(sheetData[rowIndex][columnIndex].indexOf(".")>0?new Double(sheetData[rowIndex][columnIndex]):new Integer(sheetData[rowIndex][columnIndex]));
					}else{
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(sheetData[rowIndex][columnIndex]);
					}
				}
			}
		}
		wb.write(fos);
		fos.close();
	}
	
	public static void xssfWrite(String fname,Map<String, String[][]> m) throws Exception{
		FileOutputStream fos = new FileOutputStream(fname);
		XSSFWorkbook wb=new XSSFWorkbook();
		for(Map.Entry<String, String[][]> entry:m.entrySet()){
			XSSFSheet sheet=wb.createSheet(entry.getKey());
			String[][] sheetData=entry.getValue();
			for(int rowIndex=0;rowIndex<sheetData.length;rowIndex++){
				XSSFRow row=sheet.createRow(rowIndex);
				for(int columnIndex=0;columnIndex<sheetData[rowIndex].length;columnIndex++){
					XSSFCell cell=row.createCell(columnIndex);
					if(ValidateUtils.isNullOrIsEmpty(sheetData[rowIndex][columnIndex])){
						cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
					}
					if(ValidateUtils.isNumber(sheetData[rowIndex][columnIndex])){
						cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
						cell.setCellValue(sheetData[rowIndex][columnIndex].indexOf(".")>0?new Double(sheetData[rowIndex][columnIndex]):new Integer(sheetData[rowIndex][columnIndex]));
					}else{
						cell.setCellType(XSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(sheetData[rowIndex][columnIndex]);
					}
				}
			}
		}
		wb.write(fos);
		fos.close();
	}
	
}
