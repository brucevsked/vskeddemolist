package com.vsked.test.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFromSelectedRowsAndColumns {

    public static void main(String[] args) {
        try {
            // excel files
            FileInputStream excellFile1 = new FileInputStream(new File("C:\\inputExcel.xlsx"));
            
            // input row numbers and column numbers
            int[] irows = { 0, 1, 5, 6, 10 };
            int[] icols = { 0, 2, 3, 6 };
            
            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(excellFile1);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // add sheet2 to sheet1
            XSSFWorkbook outWorkbook = getFilteredWorkBook(sheet, irows, icols);
            excellFile1.close();

            // save merged file
            File outFile = new File("C:\\filtered.xlsx");
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(outFile);
            outWorkbook.write(out);
            out.close();
            System.out.println("Files were merged succussfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static XSSFWorkbook getFilteredWorkBook(XSSFSheet sheet,  int[] irows, int[] icols) {
        // create New workbook 
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet outSheet = workbook.createSheet();
        Map<Integer, XSSFCellStyle> styleMap = new HashMap<Integer, XSSFCellStyle>();
        int i = 0;
        
        // get rows with given row numbers 
        for (int rowNum : irows) {
            if (rowNum >= sheet.getFirstRowNum() && rowNum <= sheet.getLastRowNum()) {
                
                // create new row
                XSSFRow outRow = outSheet.createRow(i);
                XSSFRow row = sheet.getRow(rowNum);
                int j = 0;
                
                // get columns with given column numbers
                for (int colNum : icols) {
                    if (colNum >= sheet.getRow(0).getFirstCellNum() && colNum <= sheet.getRow(0).getLastCellNum()) {
                        
                        // create new column
                        XSSFCell outCell = outRow.createCell(j);
                        XSSFCell cell = row.getCell(colNum);
                        if (cell != null) {
                            j++;
                            if (cell.getSheet().getWorkbook() == outCell .getSheet().getWorkbook()) {
                                outCell.setCellStyle(cell.getCellStyle());
                            } else {
                                int stHashCode = cell.getCellStyle().hashCode();
                                XSSFCellStyle newCellStyle = styleMap .get(stHashCode);
                                if (newCellStyle == null) {
                                    newCellStyle = outCell.getSheet().getWorkbook().createCellStyle();
                                    newCellStyle.cloneStyleFrom(cell .getCellStyle());
                                    styleMap.put(stHashCode, newCellStyle);
                                }
                                outCell.setCellStyle(newCellStyle);
                            }

                            switch (cell.getCellType()) {
                            case HSSFCell.CELL_TYPE_FORMULA:
                                outCell.setCellFormula(cell.getCellFormula());
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                outCell.setCellValue(cell.getNumericCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_STRING:
                                outCell.setCellValue(cell.getStringCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_BLANK:
                                outCell.setCellType(HSSFCell.CELL_TYPE_BLANK);
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN:
                                outCell.setCellValue(cell.getBooleanCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_ERROR:
                                outCell.setCellErrorValue(cell
                                        .getErrorCellValue());
                                break;
                            default:
                                outCell.setCellValue(cell.getStringCellValue());
                                break;
                            }

                        }

                    }
                }
                i++;
            }
        }
        return workbook;

    }

}
