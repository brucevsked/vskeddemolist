package com.vsked.test;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class ExcelTest {

    private static final Logger log = LoggerFactory.getLogger(ExcelTest.class);

    @Test
    public void test1a() {
        try {
            FileOutputStream fos = new FileOutputStream("c:/test/stt12.xlsx");
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet();

            //-----------------------------------------------------第1行开始
            /*
             * 设定合并单元格区域范围
             *  firstRow  0-based
             *  lastRow   0-based
             *  firstCol  0-based
             *  lastCol   0-based
             */
            CellRangeAddress cra00 = new CellRangeAddress(0, 0, 0, 8);//合并第1行的第1个单元格到第9个单元格
            //在sheet里增加合并单元格
            sheet.addMergedRegion(cra00); //合并区域添加到工作表

            Row row0 = sheet.createRow(0); //创建第1行
            Cell cell0_0 = row0.createCell(0);//第1行第1列 也就是合并以后的那个
            cell0_0.setCellValue("2017年5月代理商T+3月开来显返还0.5元明细（预收）"); //设置单元格内容

            //-----------------------------------------------------第1行结束
            //-----------------------------------------------------第2行开始
            Row row1 = sheet.createRow(1); //第2行

            Cell cell1_0 = row1.createCell(0); //创建第2行第1列
            cell1_0.setCellValue("序列");

            Cell cell1_1 = row1.createCell(1); //创建第2行第2列
            cell1_1.setCellValue("提卡日期");

            Cell cell1_2 = row1.createCell(2); //创建第2行第3列
            cell1_2.setCellValue("客户");

            Cell cell1_3 = row1.createCell(3); //创建第2行第4列
            cell1_3.setCellValue("渠道经理");

            Cell cell1_4 = row1.createCell(4); //创建第2行第5列
            cell1_4.setCellValue("号卡类别");

            Cell cell1_5 = row1.createCell(5); //创建第2行第6列
            cell1_5.setCellValue("开来显数量");

            Cell cell1_6 = row1.createCell(6); //创建第2行第7列
            cell1_6.setCellValue("返还金额");

            Cell cell1_7 = row1.createCell(7); //创建第2行第8列
            cell1_7.setCellValue("实发金额");

            Cell cell1_8 = row1.createCell(8); //创建第2行第9列
            cell1_8.setCellValue("备注");

            //-----------------------------------------------------第2行结束

            //-----------------------------------------------------第3行开始
            for (int i = 1; i < 10; i++) {
                Row row2 = sheet.createRow(i); //第3行

                Cell cell2_0 = row2.createCell(0); //创建第3行第1列
                cell2_0.setCellValue("" + i);

                Cell cell2_1 = row2.createCell(1); //创建第3行第2列
                cell2_1.setCellValue("2017.1." + i);

                Cell cell2_2 = row2.createCell(2); //创建第3行第3列
                cell2_2.setCellValue("客户a" + i);

                Cell cell2_3 = row2.createCell(3); //创建第3行第4列
                cell2_3.setCellValue("渠道经理a" + i);

                Cell cell2_4 = row2.createCell(4); //创建第3行第5列
                cell2_4.setCellValue("SAAA10卡潍坊1715555" + "|" + i);

                Cell cell2_5 = row2.createCell(5); //创建第3行第6列
                cell2_5.setCellValue(i + 100);

                Cell cell2_6 = row2.createCell(6); //创建第3行第7列
                cell2_6.setCellValue("");

                Cell cell2_7 = row2.createCell(7); //创建第3行第8列
                cell2_7.setCellValue("");

                Cell cell2_8 = row2.createCell(8); //创建第3行第9列
                cell2_8.setCellValue("");
            }
            //-----------------------------------------------------第3行结束

            wb.write(fos);

            fos.close();
            wb.close();
        } catch (Exception e) {
            log.error("write excel file error ",e);
        }
    }

}
