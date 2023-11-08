package com.java.study.lib.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel1 {

    public static void main(String[] args) throws IOException {


        try (Workbook workbook = new XSSFWorkbook();) {
            // new HSSFWorkbook();  // .xls
//              Workbook workbook = new XSSFWorkbook(); // .xlsx

            Sheet sheet = workbook.createSheet("김준범");

            List<List<String>> valueListAndList = new ArrayList<>();
            valueListAndList.add(Arrays.asList("소속", "성별", "이름", "별명"));
            valueListAndList.add(Arrays.asList("에이콘컴퍼니", "남자", "김준호", "김준범"));
            valueListAndList.add(Arrays.asList("에이콘컴퍼니", "남자", "김유섭", "유기섭"));
            valueListAndList.add(Arrays.asList("에이콘컴퍼니", "남자", "유기섭", "윾섭"));
            valueListAndList.add(Arrays.asList("에이콘컴퍼니", "남자", "김섭유", "섭섭ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ"));

            // 컬럼길이는 제목을 기준 (그니까 맨처음꺼 기준)
            for (int k = 0; k < valueListAndList.size(); k++) {
                sheet.autoSizeColumn(k);
                sheet.setColumnWidth(k, (sheet.getColumnWidth(k)) + 1024); //너비 더 넓게
            }


            for (int i = 0; i < valueListAndList.size(); i++) {
                Row row = sheet.createRow(i);
                List<String> textList = valueListAndList.get(i);

                for (int j = 0; j < textList.size(); j++) {

                    Cell cell = row.createCell(j);
                    CellStyle cellStyle = workbook.createCellStyle();

                    if (i == 0) {
                        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    }

                    // 정렬
                    cellStyle.setAlignment(HorizontalAlignment.CENTER);
                    cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

                    cellStyle.setBorderBottom(BorderStyle.THIN);
                    cellStyle.setBorderLeft(BorderStyle.THIN);
                    cellStyle.setBorderRight(BorderStyle.THIN);
                    cellStyle.setBorderBottom(BorderStyle.THIN);

                    cellStyle.setWrapText(true);    // 셀 크기에 맞추어 개행

                    cell.setCellStyle(cellStyle);


                    String text = textList.get(j);
                    cell.setCellValue(text);

                }


            }

            String fileName = "탬플릿.xlsx";

            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
