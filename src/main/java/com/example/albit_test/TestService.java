package com.example.albit_test;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;

@Service
public class TestService {

    private Workbook workbook;
    private Sheet sheet;
    private FileInputStream fileInputStream;
    private Row row;
    private Cell cell;

    public void excelImport() throws Exception {
        String filePath = "C:\\Users\\HANGYEOL\\Desktop\\albit_test\\src\\main\\resources\\static\\albit_sample_data.xlsx";
        fileInputStream = new FileInputStream(filePath);
        workbook = WorkbookFactory.create(fileInputStream);
        sheet = workbook.getSheetAt(0);

        int noOfRows = sheet.getLastRowNum();
        //System.out.println("테스트 " +noOfRows);

        for (int i = 1; i <= noOfRows; i++) {
            System.out.print(sheet.getRow(i).getCell(0));
            System.out.print(", "+sheet.getRow(i).getCell(1));
            System.out.print(", "+sheet.getRow(i).getCell(2));
            System.out.print(", "+sheet.getRow(i).getCell(3));
            System.out.print(", "+sheet.getRow(i).getCell(4));
            System.out.print(", "+sheet.getRow(i).getCell(5));
            System.out.println(", "+sheet.getRow(i).getCell(6));
        }

    }

}
