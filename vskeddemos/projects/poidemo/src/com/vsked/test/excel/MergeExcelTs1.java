package com.vsked.test.excel;

import java.io.InputStream;

import com.aspose.cells.License;
import com.aspose.cells.Workbook;

public class MergeExcelTs1 {
    //合并excel文件
	public static void main(String[] args) throws Exception {
		 if (!getLicense()) {    return;      }
		 
		 Workbook wb1=new Workbook("c:/001.xlsx");
		 Workbook wb2=new Workbook("c:/002.xlsx");
		 
		 wb1.combine(wb2);
		 wb1.save("c:/result.xlsx");
	}
	
    public static boolean getLicense() {
        boolean result = false;
        InputStream is = MergeExcelTs1.class.getClassLoader().getResourceAsStream("\\license.xml");

        License aposeLic = new License();
        try {
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
