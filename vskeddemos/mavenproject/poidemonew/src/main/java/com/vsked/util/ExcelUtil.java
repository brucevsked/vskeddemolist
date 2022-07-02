//package com.vsked.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.openxml4j.opc.OPCPackage;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class ExcelUtil {
//
//	private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);
//
//	public static String isNumberReg="^0|[0-9]\\d*(\\.\\d+)?$";
//	private static String isDateFormate1="\\d{2}-.*-\\d{4}"; //01-Apr-2017或 15-四月-2017
//	private static Pattern r = Pattern.compile(isDateFormate1);
//	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//	private static String[] cnMonth={"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
//	private static String[] enMonth={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
//
//	/**
//	 * 读取xls或xlsx文件
//	 * @param filePath 文件路径
//	 * @return Map<工作表名,行数据list中放列数组>
//	 * @throws Exception
//	 */
//	public static Map<String, List<String[]>> readExcel03And07(String filePath) throws Exception{
//		Map<String, List<String[]>> m=new TreeMap<String, List<String[]>>();
//		Workbook wb = null;
//		if(log.isDebugEnabled()){
//			log.debug(filePath);
//		}
//		InputStream stream = new FileInputStream(filePath);
//		if(filePath.endsWith(".xls")){
//			wb = new HSSFWorkbook(stream);
//		}else if(filePath.endsWith(".xlsx")){
//			wb = new XSSFWorkbook(stream);
//		}else{
//			stream.close();
//			throw new Exception("not xls or xlsx file,please check filename");
//		}
//
//		Iterator<Sheet> sheetIt=wb.sheetIterator();
//		while(sheetIt.hasNext()){
//			Sheet sheet=sheetIt.next();
//			List<String[]> sheetDataList=new LinkedList<String[]>();
//			for(Row row:sheet){
//				String[] columnArray=new String[row.getLastCellNum()];
//				for(int i=0;i<columnArray.length;i++){
////				  log.debug(row.getCell(i)+"|");
//				  columnArray[i]=getValueFor03And07(row.getCell(i));
//				}
//				sheetDataList.add(columnArray);
//			}
//			m.put(sheet.getSheetName(), sheetDataList);
//		}
//		wb.close();
//		stream.close();
//		return m;
//	}
//
//	/**
//	 * 读取xls或xlsx文件 指定开始读取行数
//	 * @param filePath 文件路径
//	 * @param startRow 起始行数
//	 * @return Map<工作表名,行数据list中放列数组>
//	 * @throws Exception
//	 */
//	public static Map<String, List<String[]>> readExcel03And07(String filePath,int startRow) throws Exception{
//		startRow=startRow<=0?0:startRow;
//		Map<String, List<String[]>> m=new TreeMap<String, List<String[]>>();
//		Workbook wb = null;
//		if(log.isDebugEnabled()){
//		log.debug(filePath);
//		}
//		InputStream stream = new FileInputStream(filePath);
//		if(filePath.endsWith(".xls")){
//			wb = new HSSFWorkbook(stream);
//		}else if(filePath.endsWith(".xlsx")){
//			wb = new XSSFWorkbook(stream);
//		}else{
//			stream.close();
//			throw new Exception("not xls or xlsx file,please check filename");
//		}
//
//		Iterator<Sheet> sheetIt=wb.sheetIterator();
//		while(sheetIt.hasNext()){
//			Sheet sheet=sheetIt.next();
//			List<String[]> sheetDataList=new LinkedList<String[]>();
//			int myRowIndex=startRow;
//			Row row=null;
//			for(myRowIndex=startRow;myRowIndex<=sheet.getLastRowNum();myRowIndex++){
//				row=sheet.getRow(myRowIndex);
//				String[] columnArray=new String[row.getLastCellNum()];
//				for(int i=0;i<columnArray.length;i++){
////				  log.debug(row.getCell(i)+"|");
//				  columnArray[i]=getValueFor03And07(row.getCell(i));
//				}
//				sheetDataList.add(columnArray);
//			}
//			m.put(sheet.getSheetName(), sheetDataList);
//		}
//		wb.close();
//		stream.close();
//		return m;
//	}
//
//	/**
//	 * 只读取xlsx文件
//	 * @param fname 文件路径
//	 * @return Map<工作表名,行数据list中放列数组>
//	 * @throws Exception
//	 */
//	@SuppressWarnings("resource")
//	public static Map<String, List<String[]>> xssfRead1(String fname)
//			throws Exception {
//		Map<String, List<String[]>> m = new TreeMap<String, List<String[]>>();
//
//		List<String[]> sheetData = null;
//
//		String cellData = "";
//		OPCPackage pkg = OPCPackage.open(new File(fname));
//		XSSFWorkbook wb = new XSSFWorkbook(pkg);
//		int sheetCount = wb.getNumberOfSheets();
//		for (int sheetIndex = 0; sheetIndex < sheetCount; sheetIndex++) {
//			XSSFSheet sheet = wb.getSheetAt(sheetIndex);
//			String sheetName = sheet.getSheetName();
//			sheetData = new LinkedList<String[]>();
//			int rowCount = sheet.getPhysicalNumberOfRows();
//			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
//				Row row = sheet.getRow(rowIndex);
//				int columnCount = row == null ? 0 : row.getLastCellNum();
//
//				String[] rowData = new String[columnCount];
//				boolean flag = false;
//				int tmpCount = 0;
//				for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
//					Cell cell = row.getCell(columnIndex);
//					cellData = cell.toString();
//					rowData[columnIndex] = cellData;
//					if (cellData == null || "".equals(cellData))
//						tmpCount++;
//					if (tmpCount == columnCount - 1)
//						flag = true;
//				}
//				if (!flag)
//					sheetData.add(rowData);
//			}
//			m.put(sheetName, sheetData);
//		}
//
//		pkg.close();
//
//		return m;
//	}
//
//	public static void xssfWrite(String fname,Map<String, String[][]> m) throws Exception{
//		FileOutputStream fos = new FileOutputStream(fname);
//		XSSFWorkbook wb=new XSSFWorkbook();
//		for(Map.Entry<String, String[][]> entry:m.entrySet()){
//			XSSFSheet sheet=wb.createSheet(entry.getKey());
//			String[][] sheetData=entry.getValue();
//			for(int rowIndex=0;rowIndex<sheetData.length;rowIndex++){
//				XSSFRow row=sheet.createRow(rowIndex);
//				for(int columnIndex=0;columnIndex<sheetData[rowIndex].length;columnIndex++){
//					XSSFCell cell=row.createCell(columnIndex);
//					if(isNullOrIsEmpty(sheetData[rowIndex][columnIndex])){
//						cell.setCellType(CellType.BLANK);
//					}
//					if(isNumber(sheetData[rowIndex][columnIndex])){
//						cell.setCellType(CellType.NUMERIC);
//						cell.setCellValue(sheetData[rowIndex][columnIndex].indexOf(".")>0?new Double(sheetData[rowIndex][columnIndex]):new Integer(sheetData[rowIndex][columnIndex]));
//					}else{
//						cell.setCellType(CellType.STRING);
//						cell.setCellValue(sheetData[rowIndex][columnIndex]);
//					}
//				}
//			}
//		}
//		wb.write(fos);
//		fos.close();
//		wb.close();
//	}
//
//	public static void xssfWrite1(String fname,Map<String, List<String[]>> m) throws Exception{
//		FileOutputStream fos = new FileOutputStream(fname);
//		XSSFWorkbook wb=new XSSFWorkbook();
//		int rowCount=0;
//		int colCount=0;
//		for(Map.Entry<String, List<String[]>> entry:m.entrySet()){
//			XSSFSheet sheet=wb.createSheet(entry.getKey());
//			List<String[]> sheetData=entry.getValue();
//			rowCount=sheetData.size();
//			for(int rowIndex=0;rowIndex<rowCount;rowIndex++){
//				XSSFRow row=sheet.createRow(rowIndex);
//				colCount=sheetData.get(rowIndex).length;
//				for(int columnIndex=0;columnIndex<colCount;columnIndex++){
//					XSSFCell cell=row.createCell(columnIndex);
//					if(isNullOrIsEmpty(sheetData.get(rowIndex)[columnIndex])){
//						cell.setCellType(CellType.BLANK);
//					}
//					if(isNumber(sheetData.get(rowIndex)[columnIndex])){
//						cell.setCellType(CellType.NUMERIC);
//						cell.setCellValue(sheetData.get(rowIndex)[columnIndex].indexOf(".")>0?new Double(sheetData.get(rowIndex)[columnIndex]):new Integer(sheetData.get(rowIndex)[columnIndex]));
//					}else{
//						cell.setCellType(CellType.STRING);
//						cell.setCellValue(sheetData.get(rowIndex)[columnIndex]);
//					}
//				}
//			}
//		}
//		wb.write(fos);
//		fos.close();
//		wb.close();
//	}
//
//	public static String getValueFor03And07(Cell c){
//		if(c==null){
//			return "";
//
//		}else if(c.getCellType()==CellType.NUMERIC){
//			String s=c.toString();
//			//自定义日期格式处理 bug fixed for poi
//			if(isDate1(s)){
//				return sdf.format(DateUtil.getJavaDate(c.getNumericCellValue()));
//			}
//			c.setCellType(CellType.STRING);
//			return c.getStringCellValue();
//		}else{
//			return c.toString();
//		}
//	}
//
//
//
//	public static boolean isNumber(String s){
//		Pattern pattern = Pattern.compile(isNumberReg);
//		return (s!=null) && (!"".equals(s)) && (pattern.matcher(s).matches());
//	}
//
//	public static boolean isEmpty(String s){
//		return "".equals(s);
//	}
//
//	public static boolean isNull(String s){
//		return s==null;
//	}
//
//	public static boolean isNullOrIsEmpty(String s){
//		return isNull(s)||isEmpty(s);
//	}
//
//	/**
//	 * 判断是否为日期格式 01-Apr-2017
//	 * @param s 01-Apr-2017
//	 * @return
//	 */
//	public static boolean isDate1(String s){
//		Matcher m = r.matcher(s);
//		return m.matches();
//	}
//
//	/**
//	 * 将传入日期01-Apr-2017格式化为2017-04-01
//	 * @param myDate 格式01-Apr-2017
//	 * @return
//	 */
//	public static String dateFormat1(String myDate){
//		@SuppressWarnings("deprecation")
//		Date d=new Date(myDate);
//		return sdf.format(d);
//	}
//
//	/**
//	 * 将中文月份转成英文朋份
//	 * @param s
//	 * @return
//	 */
//	public static String cnMonthToEnDate(String s){
//		for(int i=0;i<cnMonth.length;i++){
//			if(s.indexOf(cnMonth[i])>0){
//				s=s.replace(cnMonth[i], enMonth[i]);
//				return s;
//			}
//		}
//		return s;
//	}
//
//}