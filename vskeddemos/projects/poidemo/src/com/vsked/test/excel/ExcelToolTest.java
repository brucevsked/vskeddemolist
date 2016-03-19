package com.vsked.test.excel;

import com.vsked.util.ExcelTool;

public class ExcelToolTest {

	public static void main(String[] args) throws Exception {
//		SXSSFWrite1Test();
	}
	
	public static void SXSSFWrite1Test() throws Exception{
		int cacheRowCount=1000; //-1 is no cache
		String savePath="sxssfTest.xlsx";
		int rowNum=100000;
		int colNum=5;
		String[][] data=new String[rowNum][colNum];
		for(int rowIndex=0;rowIndex<rowNum;rowIndex++){
			for(int colIndex=0;colIndex<colNum;colIndex++){
				data[rowIndex][colIndex]=""+rowIndex+"|"+colIndex;
			}
			
		}
		System.out.println(data.length);
		System.out.println(data[0].length);
		long writeStartTime=System.currentTimeMillis();
		ExcelTool.SXSSFWrite1(data, cacheRowCount, savePath);
		System.out.println("耗时 :"+(System.currentTimeMillis()-writeStartTime)/1000f+" 秒 ");
	}

}
