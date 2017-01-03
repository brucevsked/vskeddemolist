package com.vsked.test.excel;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.vsked.util.ExcelUtilNew;

public class ExcelUtilNewTest {

	public static void main(String[] args) {
		readExcelTest();
	}
	
	public static void readExcelTest(){
		String filePath="d:/流量模板.xlsx";
		try {
			Map<String, List<String[]>> mapData=ExcelUtilNew.readExcel(filePath);
			Set<Entry<String, List<String[]>>> setData= mapData.entrySet();
			for(Map.Entry<String, List<String[]>> entry:setData){
				String sheetName=entry.getKey();
				System.out.println(sheetName);
				List<String[]> sheetData=entry.getValue();
				int rowIndex=0;
				for(String[] col:sheetData){
					if(rowIndex==0){
						rowIndex++;
						continue; // 不读第一行
					}
					System.out.print(rowIndex+"|");
					for(String columnData:col){
						System.out.print(columnData+"|");
					}
					System.out.println();
					rowIndex++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
