package com.vsked.test.excel;

import com.aspose.cells.Cell;
import com.aspose.cells.Cells;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;


public class AsposeExcel {

	public static void main(String[] args) {
		read();
	}
	
	public static void read(){
		String path="d:/data_back.xls";
		Workbook workbook = new Workbook();
		try {
			workbook.open(path);
			Worksheet worksheet =workbook.getWorksheets().get(0);
			Cells cells=worksheet.getCells();
			
			for(int i=0;i<cells.getMaxRow();i++){
				Cell cell=cells.get(i);
				System.out.println(cell.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
