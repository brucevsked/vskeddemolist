package com.vsked.test;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import com.vsked.util.ExcelUtil;

public class ExcelUtilTest {
	
	private static Logger log = Logger.getLogger(ExcelUtilTest.class);
	
	@Before
	public void initLog4j(){
        try {
        	String configFile=ExcelUtilTest.class.getResource("/").toString();
        	configFile=configFile.replace("file:/", "");
        	configFile=configFile.replace("test-classes/", "classes/"); //for maven+junit+log4j
        	configFile+="properties/log4j.properties";
        	PropertyConfigurator.configure(configFile);  
        } catch (Exception ex) {  
            System.err.println("Cannot Initialize log4j");  
        } 
	}
	
//	@Test
	public void readExcel03And07(){
		try{
		String filePath="e:/yuante.xlsx";
		long start=System.currentTimeMillis();
		Map<String, List<String[]>> dataMapAll=ExcelUtil.readExcel03And07(filePath);
		log.debug(dataMapAll.size());
		long end=System.currentTimeMillis();
		log.debug("|s1|"+(end-start));//1990 ms this method more faster
		
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void xssfRead1(){
		try{
		String filePath="e:/yuante.xlsx";
		long start=System.currentTimeMillis();
		Map<String, List<String[]>> dataMapAll=ExcelUtil.xssfRead1(filePath);
		log.debug(dataMapAll.size());
		long end=System.currentTimeMillis();
		log.debug("|s2|"+(end-start));//2480 ms this method slow
		
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void testWriteCellAttach(){
		/**
		 * 注意excel单元格与行坐标从0开始
		 */
		try {
			FileOutputStream fos=new FileOutputStream("e:/stt11.xlsx");
			Workbook wb=new XSSFWorkbook();
			Sheet sheet=wb.createSheet();
			//--------------------------------表头数据 start
			Row row0 = sheet.createRow(0); //创建表头行 也就是第1行
			
			Cell cell0_0 = row0.createCell(0); //创建第1行第1列
			cell0_0.setCellValue("渠道");
			
			Cell cell0_1 = row0.createCell(1); //创建第1行第2列
			cell0_1.setCellValue("客户");
			
			Cell cell0_2 = row0.createCell(2); //创建第1行第3列
			cell0_2.setCellValue("品牌");
			
			Cell cell0_3 = row0.createCell(3); //创建第1行第4列
			cell0_3.setCellValue("4.1");
			
			Cell cell0_4 = row0.createCell(4); //创建第1行第5列
			cell0_4.setCellValue("4.2");
			
			Cell cell0_5 = row0.createCell(5); //创建第1行第6列
			cell0_5.setCellValue("4.3");
			
			Cell cell0_6 = row0.createCell(6); //创建第1行第7列
			cell0_6.setCellValue("合计");
			
			//--------------------------------表头数据 end
			//-------------------------------合并后第一行数据 start
	        /* 
	         * 设定合并单元格区域范围 
	         *  firstRow  0-based 
	         *  lastRow   0-based 
	         *  firstCol  0-based 
	         *  lastCol   0-based 
	         */  
	        CellRangeAddress cra20=new CellRangeAddress(1, 3, 0,0);//合并第1列的第2行到第4行
	        //在sheet里增加合并单元格  
	        sheet.addMergedRegion(cra20); //合并区域添加到工作表
	        
	        Row row1 = sheet.createRow(1); //创建第2行
	        Cell cell1_0 = row1.createCell(0);//第2行第1列 也就是合并以后的那个
	        cell1_0.setCellValue("qudao1"); //设置单元格内容
	        
	        /* 
	         * 设定合并单元格区域范围 
	         *  firstRow  0-based 
	         *  lastRow   0-based 
	         *  firstCol  0-based 
	         *  lastCol   0-based 
	         */  
	        CellRangeAddress cra21=new CellRangeAddress(1, 3, 1,1);//合并第2列的第2行到第4行
	        //在sheet里增加合并单元格  
	        sheet.addMergedRegion(cra21);//合并区域添加到工作表
	        
	        Cell cell1_1 = row1.createCell(1);//第2行第2列 也就是合并以后的那个
	        cell1_1.setCellValue("kehu1"); //设置第2行第2列内容
	        
	        Cell cell1_2 = row1.createCell(2);//第2行第3列
	        cell1_2.setCellValue("yuante1");//设置第2行第3列内容
	        //----------------日期数据部分start 
	        Cell cell1_3 = row1.createCell(3);//第2行第4列
	        cell1_3.setCellValue(24);//设置第2行第4列内容  注意这里加的是数字不是文本
	        
	        Cell cell1_4 = row1.createCell(4);//第2行第5列
	        cell1_4.setCellValue(25);//设置第2行第5列内容   注意这里加的是数字不是文本
	        
	        Cell cell1_5 = row1.createCell(5);//第2行第6列
	        cell1_5.setCellValue(26);//设置第2行第5列内容   注意这里加的是数字不是文本
	        
	        //----------------日期数据部分end
	        //合计列start
	        Cell cell1_6 = row1.createCell(6);//第2行第7列
	        cell1_6.setCellType(CellType.FORMULA); //设置公式
	        cell1_6.setCellFormula("D2+E2+F2"); //设置公式内容
	        //合计列end
	        
	        Row row2 = sheet.createRow(2);//创建第3行
	        Cell cell2_1 = row2.createCell(2);//第3行第3列 
	        cell2_1.setCellValue("woniu1");//第3行第3列内容
	        
	        //----------------日期数据部分start 
	        Cell cell2_3 = row2.createCell(3);//第3行第4列
	        cell2_3.setCellValue(34);//设置第2行第4列内容  注意这里加的是数字不是文本
	        
	        Cell cell2_4 = row2.createCell(4);//第3行第5列
	        cell2_4.setCellValue(35);//设置第2行第5列内容   注意这里加的是数字不是文本
	        
	        Cell cell2_5 = row2.createCell(5);//第3行第6列
	        cell2_5.setCellValue(36);//设置第2行第5列内容   注意这里加的是数字不是文本
	        
	        //----------------日期数据部分end 
	        //合计列start
	        Cell cell2_6 = row2.createCell(6);//第2行第7列
	        cell2_6.setCellType(CellType.FORMULA); //设置公式
	        cell2_6.setCellFormula("D3+E3+F3"); //设置公式内容
	        //合计列end
	        
	        Row row3 = sheet.createRow(3); //创建第4行
	        Cell cell3_2 = row3.createCell(2);//第4行第3列
	        cell3_2.setCellValue("dijia1");//第4行第3列内容
	        
	        //----------------日期数据部分start 
	        Cell cell3_3 = row3.createCell(3);//第4行第4列
	        cell3_3.setCellValue(44);//设置第2行第4列内容  注意这里加的是数字不是文本
	        
	        Cell cell3_4 = row3.createCell(4);//第4行第5列
	        cell3_4.setCellValue(45);//设置第2行第5列内容   注意这里加的是数字不是文本
	        
	        Cell cell3_5 = row3.createCell(5);//第4行第6列
	        cell3_5.setCellValue(46);//设置第2行第5列内容   注意这里加的是数字不是文本
	        //----------------日期数据部分end 
	        //合计列start
	        Cell cell3_6 = row3.createCell(6);//第2行第7列
	        cell3_6.setCellType(CellType.FORMULA); //设置公式
	        cell3_6.setCellFormula("D4+E4+F4"); //设置公式内容
	        //合计列end
	      //-------------------------------合并后第一行数据 end
	        
	        wb.write(fos);  
	          
	        fos.close();
	        wb.close();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void xssfWrite(){
		try{
			String fname="e:/t2a1.xlsx";
			Map<String, String[][]> sheetData=new HashMap<String, String[][]>();
			int rowCount=10;
			int colCount=5;
			String[][] rowData=new String[rowCount][colCount];
			for(int rowIndex=0;rowIndex<rowCount;rowIndex++){
				for(int columnIndex=0;columnIndex<colCount;columnIndex++){
					rowData[rowIndex][columnIndex]=rowIndex+columnIndex+"";
				}
			}
			sheetData.put("mydata2017", rowData);
			
			ExcelUtil.xssfWrite(fname, sheetData);
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
	@Test
	public void xssfWrite1(){
		try{
			String fname="e:/xxffw178.xlsx";
			Map<String, List<String[]>> sheetData=new HashMap<String, List<String[]>>();
			int rowCount=10;
			int colCount=5;
			
			List<String[]> rowData=new LinkedList<String[]>();
			for(int rowIndex=0;rowIndex<rowCount;rowIndex++){
				String[] colData=new String[colCount];
				for(int columnIndex=0;columnIndex<colCount;columnIndex++){
					colData[columnIndex]=rowIndex+columnIndex+"";
				}
				rowData.add(colData);
			}
			sheetData.put("whocare", rowData);
			
			ExcelUtil.xssfWrite1(fname, sheetData);
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void t1(){
		log.debug(11);
	}
}
