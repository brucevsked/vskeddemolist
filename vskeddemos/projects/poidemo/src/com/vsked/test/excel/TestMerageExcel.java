package com.vsked.test.excel;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.vsked.util.ExcelUtils;

public class TestMerageExcel {
	public static void main(String[] args) throws Exception {
//		testRemoveBlankLineHssf();
//		testRemoveBlankLineXssf();
//		testListMerage();
	}
	
	public static void testRemoveBlankLineHssf() throws Exception{
		String fname="c:/f1.xls";
		 Map<String, List<String[]>>  m=ExcelUtils.hssfRead1(fname);
		 for(Map.Entry<String, List<String[]>> entry:m.entrySet()){
			 String sheetName=entry.getKey();
				System.out.println("--------|"+sheetName);
				List<String[]> sheetData=entry.getValue();
				for(String[] rowData:sheetData){
					for(int i=0;i<rowData.length;i++){
						System.out.print(rowData[i]+",");
					}
					System.out.println();
				}
			 
		 }
	}
	
	public static void testRemoveBlankLineXssf() throws Exception{
		String fname="c:/f1.xlsx";
		 Map<String, List<String[]>>  m=ExcelUtils.xssfRead1(fname);
		 for(Map.Entry<String, List<String[]>> entry:m.entrySet()){
			 String sheetName=entry.getKey();
				System.out.println("--------|"+sheetName);
				List<String[]> sheetData=entry.getValue();
				for(String[] rowData:sheetData){
					for(int i=0;i<rowData.length;i++){
						System.out.print(rowData[i]+",");
					}
					System.out.println();
				}
			 
		 }
	}
	
	public static void testListMerage(){
		List<String[]> tl1=new LinkedList<String[]>();
		String[] tls1=new String[5];
		for(int i=0;i<5;i++) tls1[i]="|"+i;
		
		tl1.add(tls1);
		
		List<String[]> tl2=new LinkedList<String[]>();
		String[] tls2=new String[5];
		for(int i=0;i<5;i++) tls2[i]="|"+i*3;
		
		tl2.add(tls2);
		
		tl1.addAll(tl2);
		
		for(String[] tls:tl1){
			for(int i=0;i<tls.length;i++){
				System.out.print(tls[i]+"|");
			}
			System.out.println();
		}
		
	}

}
