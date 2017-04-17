package com.vsked.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static String isNumberReg="^0|[0-9]\\d*(\\.\\d+)?$";
	
	/**
	 * 读取xls或xlsx文件
	 * @param filePath 文件路径
	 * @return Map<工作表名,行数据list中放列数组>
	 * @throws Exception
	 */
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
	
	/**
	 * 只读取xlsx文件
	 * @param filePath 文件路径
	 * @return Map<工作表名,行数据list中放列数组>
	 * @throws Exception
	 */
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
					if(isNullOrIsEmpty(sheetData[rowIndex][columnIndex])){
						cell.setCellType(CellType.BLANK);
					}
					if(isNumber(sheetData[rowIndex][columnIndex])){
						cell.setCellType(CellType.NUMERIC);
						cell.setCellValue(sheetData[rowIndex][columnIndex].indexOf(".")>0?new Double(sheetData[rowIndex][columnIndex]):new Integer(sheetData[rowIndex][columnIndex]));
					}else{
						cell.setCellType(CellType.STRING);
						cell.setCellValue(sheetData[rowIndex][columnIndex]);
					}
				}
			}
		}
		wb.write(fos);
		fos.close();
		wb.close();
	}
	
	public static void xssfWrite1(String fname,Map<String, List<String[]>> m) throws Exception{
		FileOutputStream fos = new FileOutputStream(fname);
		XSSFWorkbook wb=new XSSFWorkbook();
		int rowCount=0;
		int colCount=0;
		for(Map.Entry<String, List<String[]>> entry:m.entrySet()){
			XSSFSheet sheet=wb.createSheet(entry.getKey());
			List<String[]> sheetData=entry.getValue();
			rowCount=sheetData.size();
			for(int rowIndex=0;rowIndex<rowCount;rowIndex++){
				XSSFRow row=sheet.createRow(rowIndex);
				colCount=sheetData.get(rowIndex).length;
				for(int columnIndex=0;columnIndex<colCount;columnIndex++){
					XSSFCell cell=row.createCell(columnIndex);
					if(isNullOrIsEmpty(sheetData.get(rowIndex)[columnIndex])){
						cell.setCellType(CellType.BLANK);
					}
					if(isNumber(sheetData.get(rowIndex)[columnIndex])){
						cell.setCellType(CellType.NUMERIC);
						cell.setCellValue(sheetData.get(rowIndex)[columnIndex].indexOf(".")>0?new Double(sheetData.get(rowIndex)[columnIndex]):new Integer(sheetData.get(rowIndex)[columnIndex]));
					}else{
						cell.setCellType(CellType.STRING);
						cell.setCellValue(sheetData.get(rowIndex)[columnIndex]);
					}
				}
			}
		}
		wb.write(fos);
		fos.close();
		wb.close();
	}
	
	public static String getValueFor03And07(Cell c){
		if(c.getCellTypeEnum()==CellType.NUMERIC){
			c.setCellType(CellType.STRING);
			return c.getStringCellValue();
		}else{
			return c.toString();
		}
	}
	

	
	public static boolean isNumber(String s){
		Pattern pattern = Pattern.compile(isNumberReg);
		return (s!=null) && (!"".equals(s)) && (pattern.matcher(s).matches());    
	}
	
	public static boolean isEmpty(String s){
		return "".equals(s);
	}
	
	public static boolean isNull(String s){
		return s==null;		
	}
	
	public static boolean isNullOrIsEmpty(String s){
		return isNull(s)||isEmpty(s);
	}
}