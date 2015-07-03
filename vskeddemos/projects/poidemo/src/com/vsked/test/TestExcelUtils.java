package com.vsked.test;

import java.util.HashMap;
import java.util.Map;

import com.vsked.util.ExcelUtils;

public class TestExcelUtils {
	
	public static void main(String[] args) throws Exception {
		TestExcelUtils ts=new TestExcelUtils();
		//ts.testExcelXssfRead();
		//ts.testExcelHssfRead();
		//ts.testExcelHssfWrite();
		ts.testExcelXssfWrite();
	}
	
	public String[] testExcelXssfRead() throws Exception{
		String[] rtsql=null;
		String beforeSql="insert into userT(username,password,qq,ips) values(";
		String afterSql=");";
		String fname=TestExcelUtils.class.getResource("/")+"t1.xlsx";
		fname=fname.substring(6);
		fname=fname.replace("%20", " ");
		Map<String, String[][]> m=ExcelUtils.xssfRead(fname);
		StringBuffer dt = new StringBuffer(beforeSql);
		for(Map.Entry<String, String[][]> entry:m.entrySet()){
			String sheetName=entry.getKey();
			System.out.println("--------|"+sheetName);
			String[][] sheetData=entry.getValue();
			if(sheetData!=null){
			rtsql=new String[sheetData.length];
			for(int i=0;i<sheetData.length;i++){
				dt.setLength(beforeSql.length());
				for(int c=0;c<sheetData[i].length;c++){
					dt.append((c==0?"":",")+sheetData[i][c]);
				}
				rtsql[i]=dt.toString()+afterSql;
				System.out.println(rtsql[i]);
			}
			}
		}
		return rtsql;
	}
	
	public String[] testExcelHssfRead() throws Exception{
		String[] rtsql=null;
		String beforeSql="insert into userT(username,password,qq,ips) values(";
		String afterSql=");";
		String fname=TestExcelUtils.class.getResource("/")+"t1.xls";
		fname=fname.substring(6);
		fname=fname.replace("%20", " ");
		Map<String, String[][]> m=ExcelUtils.hssfRead(fname);
		StringBuffer dt = new StringBuffer(beforeSql);
		for(Map.Entry<String, String[][]> entry:m.entrySet()){
			String sheetName=entry.getKey();
			System.out.println("--------|"+sheetName);
			String[][] sheetData=entry.getValue();
			if(sheetData!=null){
			rtsql=new String[sheetData.length];
			for(int i=0;i<sheetData.length;i++){
				dt.setLength(beforeSql.length());
				for(int c=0;c<sheetData[i].length;c++){
					dt.append((c==0?"":",")+sheetData[i][c]);
				}
				rtsql[i]=dt.toString()+afterSql;
				System.out.println(rtsql[i]);
			}
			}
		}
		return rtsql;
	}
	
	public  Map<String, String[][]> generateData(){
		int sheetCount=5;
		int rowCount=11;
		int columnCount=5;
		String[][] sheetData=null;
		String sheetName="";
		Map<String, String[][]> m=new HashMap<String, String[][]>();
		for(int sheetIndex=0;sheetIndex<sheetCount;sheetIndex++){
			sheetName="sheet"+sheetIndex;
			sheetData=null;
		for(int rowIndex=0;rowIndex<rowCount;rowIndex++){
			if(sheetData==null){
            	sheetData= new String[rowCount][columnCount];
            }
			for(int columnIndex=0;columnIndex<columnCount;columnIndex++){
				sheetData[rowIndex][columnIndex]=""+(rowIndex+columnIndex)+" ";
			}
		}
		m.put(sheetName, sheetData);
		}
		return m;
	}
	
	public void testExcelHssfWrite() throws Exception{
		String fname="c:/ft1hssf.xls";
		ExcelUtils.hssfWrite(fname, generateData());
	}
	
	public void testExcelXssfWrite() throws Exception{
		String fname="c:/ft1xssf.xlsx";
		ExcelUtils.xssfWrite(fname, generateData());
	}

}
