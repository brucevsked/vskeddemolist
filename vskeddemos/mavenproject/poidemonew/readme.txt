

这里面有一个log4j+maven的配置不包括spring的那种
需要配合spring的可以参考shirorestfulpagination项目

在spring boot中导出相关示例代码

    @PostMapping("/export")
    public ResponseEntity<byte[]> exportExcel(@RequestParam("d") int d) {
        try {
            LocalDate targetDate = LocalDate.now().plusDays(d);
            LocalDateTime startOfDay = targetDate.atStartOfDay();
            LocalDateTime endOfDay = targetDate.atTime(LocalTime.MAX);
            List<Map<String, Object>> meterValues = meterValueRepository.findMeterAddrAndMeterValueByCreatedateBetween(startOfDay, endOfDay);

            if (meterValues == null || meterValues.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            String sheetName = targetDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            try (XSSFWorkbook wb = new XSSFWorkbook()) {
                XSSFSheet sheet = wb.createSheet(sheetName);
                XSSFRow headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("水表号");
                headerRow.createCell(1).setCellValue("水表值");

                sheet.setColumnWidth(0, 25 * 256);
                sheet.setColumnWidth(1, 15 * 256);

                DataFormat format = wb.createDataFormat();
                CellStyle cellStyle = wb.createCellStyle();
                cellStyle.setDataFormat(format.getFormat("0"));

                for (int i = 0; i < meterValues.size(); i++) {
                    Map<String, Object> meterValue = meterValues.get(i);
                    XSSFRow row = sheet.createRow(i + 1);

                    row.createCell(0).setCellValue(Long.valueOf(meterValue.get("meterAddr").toString()));
                    row.createCell(1).setCellValue(Long.valueOf(meterValue.get("meterValue").toString()));
                    row.getCell(0).setCellStyle(cellStyle);
                }

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                wb.write(outputStream);

                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + sheetName + ".xlsx")
                        .body(outputStream.toByteArray());
            }
        } catch (Exception e) {
            log.error("导出Excel失败", e);
            return ResponseEntity.status(500).body(null);
        }
    }