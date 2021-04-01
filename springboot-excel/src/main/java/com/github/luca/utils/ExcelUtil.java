package com.github.luca.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.EMPTY;

public class ExcelUtil {
    // excel 2003 版本 excel
    public static final String MICROSOFT_EXCEL_2003 = "xls";
    // excel 2007 版本 excel
    public static final String MICROSOFT_EXCEL_2007 = "xlsx";

    /**
     * 读取excel文件
     *
     * @param path 文件地址
     */
    public static List<List<String>> readExcel(String path) throws Exception {
        File excelFile = new File(path);
        if (!excelFile.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        FileInputStream fileInput = new FileInputStream(excelFile);
        /*
           根据文件后缀判断用xls或是xlsx处理
         */
        String[] postfixArray = path.split("\\.");
        int lastIndex = postfixArray.length - 1;
        String postfix = postfixArray[lastIndex];

        Workbook wb;
        switch (postfix) {
            case ExcelUtil.MICROSOFT_EXCEL_2003:
                wb = new HSSFWorkbook(fileInput);
                break;
            case ExcelUtil.MICROSOFT_EXCEL_2007:
                wb = new XSSFWorkbook(fileInput);
                break;
            default:
                throw new Exception("文件不符合要求");
        }
        List<List<String>> dataList = new ArrayList<>();
        /*
         * wb.getSheetAt(0) 简单的取第一个sheet的表格读取
         */
        for (Row row : wb.getSheetAt(0)) {
            List<String> rowList = new ArrayList<>();
            for (Cell cell : row) {
                rowList.add(getCellValue(cell));
            }
            dataList.add(rowList);
        }
        return dataList;
    }


    public static void exportExcel(List<List<String>> dataList) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("sheetNameTest");

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.INDIGO.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = workbook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(font);
        headerStyle.setBorderBottom(BorderStyle.THIN); //下边框
        headerStyle.setBorderLeft(BorderStyle.THIN);//左边框
        headerStyle.setBorderTop(BorderStyle.THIN);//上边框
        headerStyle.setBorderRight(BorderStyle.THIN);//右边框

        // 取标题
        List<String> headerList = dataList.get(0);
        for (int i = 0; i < headerList.size(); i++) {
            sheet.setColumnWidth(i, headerList.get(i).length()*512);
            Cell headerCell = header.createCell(i);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue(headerList.get(i));
        }

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        style.setBorderBottom(BorderStyle.THIN); //下边框
        style.setBorderLeft(BorderStyle.THIN);//左边框
        style.setBorderTop(BorderStyle.THIN);//上边框
        style.setBorderRight(BorderStyle.THIN);//右边框

        for (int i = 1; i < dataList.size(); i++) {
            Row row = sheet.createRow(i);
            List<String> rowList = dataList.get(i);
            for (int j = 0; j < rowList.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(rowList.get(j));
                cell.setCellStyle(style);
            }
        }
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "test_emp.xlsx";

        System.out.println(fileLocation);
        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();

    }

    /**
     * 单元格不同格式获取值
     */
    public static String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
                    return timeFormatter.format(cell.getLocalDateTimeCellValue());
                } else {
                    return cell.getNumericCellValue() + "";
                }
            case FORMULA:
                return cell.getCellFormula() + EMPTY;
            default:
                return EMPTY;
        }
    }
}
