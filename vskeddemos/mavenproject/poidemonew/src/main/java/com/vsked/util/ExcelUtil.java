package com.vsked.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static Map<String, List<String[]>> readExcel03And07(String filePath) throws Exception{
		Map<String, List<String[]>> m=new TreeMap<String, List<String[]>>();
		Workbook wb = null; 
		
		InputStream stream = new FileInputStream(filePath);
		if(filePath.endsWith(".xls")){
			wb = new HSSFWorkbook(stream); 
		}else if(filePath.endsWith(".xlsx")){
			wb = new XSSFWorkbook(stream);
		}else{
			stream.close();
			throw new Exception("not xls or xlsx file,please check filename");
		}
		
		Iterator<Sheet> sheetIt=wb.sheetIterator();
		while(sheetIt.hasNext()){
			Sheet sheet=sheetIt.next();
			List<String[]> sheetDataList=new LinkedList<String[]>();
			for(Row row:sheet){
				int columnIndex=0;
				String[] columnArray=new String[row.getPhysicalNumberOfCells()];
				for(Cell cell:row){
					columnArray[columnIndex]=getValueFor03And07(cell);
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
	
	public static Map<String, List<String[]>> xssfRead1(String fname)
			throws Exception {
		Map<String, List<String[]>> m = new TreeMap<String, List<String[]>>();

		List<String[]> sheetData = null;

		String cellData = "";
		OPCPackage pkg = OPCPackage.open(new File(fname));
		XSSFWorkbook wb = new XSSFWorkbook(pkg);
		int sheetCount = wb.getNumberOfSheets();
		for (int sheetIndex = 0; sheetIndex < sheetCount; sheetIndex++) {
			XSSFSheet sheet = wb.getSheetAt(sheetIndex);
			String sheetName = sheet.getSheetName();
			sheetData = new LinkedList<String[]>();
			int rowCount = sheet.getPhysicalNumberOfRows();
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				int columnCount = row == null ? 0 : row.getLastCellNum();

				String[] rowData = new String[columnCount];
				boolean flag = false;
				int tmpCount = 0;
				for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
					Cell cell = row.getCell(columnIndex);
					cellData = cell.toString();
					rowData[columnIndex] = cellData;
					if (cellData == null || "".equals(cellData))
						tmpCount++;
					if (tmpCount == columnCount - 1)
						flag = true;
				}
				if (!flag)
					sheetData.add(rowData);
			}
			m.put(sheetName, sheetData);
		}
		pkg.close();
		return m;
	}
	
	public static String getValueFor03And07(Cell c){
		if(c.getCellTypeEnum()==CellType.NUMERIC){
			c.setCellType(CellType.STRING);
			return c.getStringCellValue();
		}else{
			return c.toString();
		}
	}
}