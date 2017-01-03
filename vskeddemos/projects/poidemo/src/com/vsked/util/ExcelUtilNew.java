package com.vsked.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilNew {
	
	public static Map<String, List<String[]>> readExcel(String filePath) throws Exception{
		Map<String, List<String[]>> m=new TreeMap<String, List<String[]>>();
		Workbook wb = null; 
		
		InputStream stream = new FileInputStream(filePath);
		if(filePath.endsWith(".xls")){
			wb = new HSSFWorkbook(stream); 
		}else if(filePath.endsWith(".xlsx")){
			wb = new XSSFWorkbook(stream);
		}else{
			System.out.println("unknow file format.not xls and not xlsx");
		}
		
		Iterator<Sheet> sheetIt=wb.sheetIterator();
		while(sheetIt.hasNext()){
			Sheet sheet=sheetIt.next();
			List<String[]> sheetDataList=new LinkedList<String[]>();
			for(Row row:sheet){
				int columnIndex=0;
				String[] columnArray=new String[row.getPhysicalNumberOfCells()];
				for(Cell cell:row){
					columnArray[columnIndex]=cell.toString();
					columnIndex++;
				}
				sheetDataList.add(columnArray);
			}
			m.put(sheet.getSheetName(), sheetDataList);
		}
		wb.close();
		stream.close();
		return m;
	}
	
}
