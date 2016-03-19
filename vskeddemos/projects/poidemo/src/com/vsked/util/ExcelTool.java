package com.vsked.util;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class ExcelTool {
	
	/**
	 * 
	 * @param data
	 * @param cacheRowCount(-1 is no cache)
	 * @param savePath
	 * @throws Exception
	 */
	public static void SXSSFWrite1(String[][] data,int cacheRowCount,String savePath) throws Exception{
		SXSSFWorkbook wb = new SXSSFWorkbook(cacheRowCount);
	    Sheet sh = wb.createSheet();
	    for(int rownum = 0; rownum < data.length; rownum++){
	    	Row row = sh.createRow(rownum);
	        for(int cellnum = 0; cellnum < data[0].length; cellnum++){
	        	Cell cell = row.createCell(cellnum);
	            cell.setCellValue(data[rownum][cellnum]);
	        }
	    }
        FileOutputStream out = new FileOutputStream(savePath);
        wb.write(out);
        out.close();
        wb.dispose();
	}

}
