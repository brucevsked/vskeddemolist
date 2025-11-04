package com.vsked.test;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.vsked.util.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class ExcelUtilTest {

	private static final Logger log = LoggerFactory.getLogger(ExcelUtilTest.class);

	@Test
	public static void SXSSFWrite1Test() throws Exception{
		int cacheRowCount=1000; //-1 is no cache
		String savePath="sxssfTest.xlsx";
		int rowNum=100000;
		int colNum=5;
		String[][] data=new String[rowNum][colNum];
		for(int rowIndex=0;rowIndex<rowNum;rowIndex++){
			for(int colIndex=0;colIndex<colNum;colIndex++){
				data[rowIndex][colIndex]="|"+rowIndex+"|"+colIndex;
			}

		}
		System.out.println(data.length);
		System.out.println(data[0].length);
		long writeStartTime=System.currentTimeMillis();
		ExcelUtil.SXSSFWrite1(data, cacheRowCount, savePath);
		System.out.println("耗时 :"+(System.currentTimeMillis()-writeStartTime)/1000f+" 秒 ");
	}

	@Test
	public void readExcel03And07(){
		try{
		String filePath="d:/a.xls";
		long start=System.currentTimeMillis();
		Map<String, List<String[]>> dataMapAll=ExcelUtil.readExcel03And07(filePath);
		log.debug("{}",dataMapAll.size());
		long end=System.currentTimeMillis();
            for (Map.Entry<String, List<String[]>> entry : dataMapAll.entrySet()) {
                String sheetName = entry.getKey();
                log.debug(sheetName);
                List<String[]> lineData = entry.getValue();
                StringBuilder s;
                for (String[] lineDatum : lineData) {
                    s = new StringBuilder();
                    for (String dt : lineDatum) {
                        s.append("|").append(dt);
                    }
                    log.debug(s.toString());
                }

            }
            log.debug("|s1|{}", (end - start) / 1000);// this method more faster

		}catch(Exception e){
			log.error(e.getMessage());
		}
	}

    @Test
    public void readExcel03And07StartRow(){
        try{
            String filePath="d:/a.xls";
            long start=System.currentTimeMillis();
            Map<String, List<String[]>> dataMapAll=ExcelUtil.readExcel03And07(filePath,1);
            log.debug("{}",dataMapAll.size());
            long end=System.currentTimeMillis();
            for (Map.Entry<String, List<String[]>> entry : dataMapAll.entrySet()) {
                String sheetName = entry.getKey();
                log.debug(sheetName);
                List<String[]> lineData = entry.getValue();
                StringBuilder s;
                for (String[] lineDatum : lineData) {
                    s = new StringBuilder();
                    for (String dt : lineDatum) {
                        s.append("|").append(dt);
                    }
                    log.debug(s.toString());
                }

            }
            log.debug("|s1|{}", (end - start) / 1000);// this method more faster

        }catch(Exception e){
            log.error(e.getMessage());
        }
    }

	@Test
	public void xssfRead1(){
		try{
		String filePath="e:/YT.xlsx";
		long start=System.currentTimeMillis();
		Map<String, List<String[]>> dataMapAll=ExcelUtil.xssfRead1(filePath);
		log.debug("{}",dataMapAll.size());
		long end=System.currentTimeMillis();

            for (Map.Entry<String, List<String[]>> entry : dataMapAll.entrySet()) {
                String sheetName = entry.getKey();
                log.debug(sheetName);
                List<String[]> lineData = entry.getValue();
                StringBuilder s;
                for (String[] lineDatum : lineData) {
                    s = new StringBuilder();
                    for (String dt : lineDatum) {
                        s.append("|").append(dt).append("|");
                    }
                    log.debug(s.toString());
                }

            }
            log.debug("|s2|{}", end - start);//2480 ms this method slow

		}catch(Exception e){
			log.error(e.getMessage());
		}
	}

	@Test
	public void testWriteCellAttach(){
        //注意excel单元格与行坐标从0开始
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
	        cell1_0.setCellValue("channel1"); //设置单元格内容

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
	        cell1_1.setCellValue("customer1"); //设置第2行第2列内容

	        Cell cell1_2 = row1.createCell(2);//第2行第3列
	        cell1_2.setCellValue("YT1");//设置第2行第3列内容
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
	        cell1_6.setCellFormula("D2+E2+F2"); //设置公式内容
	        //合计列end

	        Row row2 = sheet.createRow(2);//创建第3行
	        Cell cell2_1 = row2.createCell(2);//第3行第3列
	        cell2_1.setCellValue("woNiu1");//第3行第3列内容

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
	        cell2_6.setCellFormula("D3+E3+F3"); //设置公式内容
	        //合计列end

	        Row row3 = sheet.createRow(3); //创建第4行
	        Cell cell3_2 = row3.createCell(2);//第4行第3列
	        cell3_2.setCellValue("DJ1");//第4行第3列内容

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

	@Test
	public void xssfWrite(){
		try{
			String fileName="c:/test/test1.xlsx";
			Map<String, String[][]> sheetData=new HashMap<>();
			int rowCount=10;
			int colCount=5;
			String[][] rowData=new String[rowCount][colCount];
			rowData[0][0]="列1数据";
			rowData[0][1]="列2数据";
			rowData[0][2]="列3数据";
			rowData[0][3]="列4数据";
			rowData[0][4]="列5数据";
			for(int rowIndex=1;rowIndex<rowCount;rowIndex++){
				for(int columnIndex=0;columnIndex<colCount;columnIndex++){
					rowData[rowIndex][columnIndex]=rowIndex+columnIndex+"";
				}
			}
			sheetData.put("myData2017", rowData);

			ExcelUtil.xssfWrite(fileName, sheetData);
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}

	@Test
	public void xssfWrite1(){
		try{
			String fileName="c:/test/test2.xlsx";
			Map<String, List<String[]>> sheetData=new HashMap<>();
			int rowCount=10;
			int colCount=5;

			List<String[]> rowData=new LinkedList<>();
			String[] colDataHead=new String[colCount];
			colDataHead[0]="列1数据F1";
			colDataHead[1]="列2数据F2";
			colDataHead[2]="列3数据F3";
			colDataHead[3]="列4数据F4";
			colDataHead[4]="列5数据F5";
			rowData.add(colDataHead);

			for(int rowIndex=1;rowIndex<rowCount;rowIndex++){
				String[] colData=new String[colCount];
				for(int columnIndex=0;columnIndex<colCount;columnIndex++){
					colData[columnIndex]=rowIndex+":"+columnIndex;
				}
				rowData.add(colData);
			}
			sheetData.put("whoCare", rowData);

			ExcelUtil.xssfWrite1(fileName, sheetData);
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}

	@Test
	public void writeNumberToString() throws Exception {
		String fileName="c:/test/test3.xlsx";
		String sheetName= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		FileOutputStream fos = new FileOutputStream(fileName);
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet(sheetName);
		XSSFRow row=sheet.createRow(0);
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("水表号");

		cell=row.createCell(1);
		cell.setCellValue("水表值");

		// 设置列宽
		sheet.setColumnWidth(0, 25 * 256); // "水表号" 列宽 25 字符
		sheet.setColumnWidth(1, 15 * 256); // "水表值" 列宽 15 字符

		DataFormat format = wb.createDataFormat();
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(format.getFormat("0")); // 设置为整数格式

		Random r=new Random();
		long tmpNumber=900000000000L;

		for(int i=1;i<=200;i++){
			row=sheet.createRow(i);
			cell=row.createCell(0);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(tmpNumber+r.nextInt(90000000));
			cell=row.createCell(1);
			cell.setCellValue(r.nextInt(9999));
		}

		wb.write(fos);
		fos.close();
		wb.close();
	}

	@Test
	public void writeColourCell() throws Exception {
		String fileName="c:/test/test4.xlsx";
		String sheetName= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		FileOutputStream fos = new FileOutputStream(fileName);
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet(sheetName);

		// 创建一个数据格式，指定为文本（@ 代表文本格式）
		DataFormat formatText = wb.createDataFormat();
		CellStyle textCellStyle = wb.createCellStyle();
		textCellStyle.setDataFormat(formatText.getFormat("@")); //第一步设置单元格样式成文本
		// 也可以使用 format.getFormat("TEXT")，但 "@" 是标准的文本格式代码

		// 2. 创建“成功”和“失败”的样式
		//CellStyle successStyle = createColoredCellStyle(wb, IndexedColors.LIGHT_GREEN); // 使用内置的亮绿色
		CellStyle successStyle = createCustomColoredCellStyle(wb, new byte[]{(byte) 198, (byte) 239, (byte) 206}); //RGB(198, 239, 206)

		//CellStyle failStyle = createColoredCellStyle(wb, IndexedColors.LIGHT_ORANGE); // 使用内置的浅色
		CellStyle failStyle = createCustomColoredCellStyle(wb, new byte[]{(byte) 255, (byte) 199, (byte) 206}); // 使用您指定的 RGB (255, 199, 206)


		XSSFRow row=sheet.createRow(0);
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("水表号");

		cell=row.createCell(1);
		cell.setCellValue("dtu");

		cell=row.createCell(2);
		cell.setCellValue("状态");

		// 设置列宽
		sheet.setColumnWidth(0, 25 * 256); // "水表号" 列宽 25 字符
		sheet.setColumnWidth(1, 15 * 256); // "水表值" 列宽 15 字符
		sheet.setColumnWidth(2, 25 * 256); // "状态" 列宽 25 字符

		DataFormat format = wb.createDataFormat();
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(format.getFormat("0")); // 设置为整数格式

		Random r=new Random();
		long tmpNumber=900000000000L;

		for(int i=1;i<=200;i++){
			row=sheet.createRow(i);
			cell=row.createCell(0);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(tmpNumber+r.nextInt(90000000));
			cell=row.createCell(1);
			cell.setCellStyle(textCellStyle);  //设置为文本格式，不显示科学计数法
			cell.setCellValue(String .valueOf(r.nextLong())); //第二步，将单元格的值转换成文本格式

			// 状态 (示例：随机生成成功或失败)
			cell = row.createCell(2);
			boolean isSuccess = r.nextBoolean(); // 随机决定成功或失败，您可以替换为您的业务逻辑
			cell.setCellValue(isSuccess ? "成功" : "失败");
			// 根据结果应用不同的样式
			cell.setCellStyle(isSuccess ? successStyle : failStyle);
		}

		wb.write(fos);
		fos.close();
		wb.close();
	}

	/**
	 * 创建一个使用内置颜色索引的单元格样式。
	 * @param workbook 工作簿
	 * @param color 内置颜色
	 * @return CellStyle
	 */
	private CellStyle createColoredCellStyle(XSSFWorkbook workbook, IndexedColors color) {
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(color.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return style;
	}

	/**
	 * 创建一个使用自定义RGB颜色的单元格样式。
	 * @param workbook 工作簿
	 * @param rgb 颜色数组 {R, G, B}，每个值为byte类型 (0-255)
	 * @return CellStyle
	 */
	private CellStyle createCustomColoredCellStyle(XSSFWorkbook workbook, byte[] rgb) {
		// 在工作簿中注册自定义颜色
		XSSFColor customColor = new XSSFColor(rgb, new DefaultIndexedColorMap());
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(customColor);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return style;
	}
}
