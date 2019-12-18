package com.example.albit_test;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        sheet = workbook.getSheetAt(0); // 해당 파일의 몇번째 시트를 읽어올 것인지 설정
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" / ");
            }
            System.out.println();
        }

        workbook.close();
        fileInputStream.close();
    }

    public List<Albit> readExcelFile() throws IOException {
        List<Albit> list = new ArrayList<>();
        String filePath = "C:\\Users\\HANGYEOL\\Desktop\\springboot_excel_parse\\src\\main\\resources\\static\\bbbb.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        Workbook testWorkbook = WorkbookFactory.create(inputStream);
        Sheet firstSheet = testWorkbook.getSheetAt(0);

        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Albit albit = new Albit();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();
                // Integer.parseInt
                // String.valueOf
                switch (columnIndex) {
                    case 0:
                        albit.setName((String) getCellValue(nextCell));
                        break;
                    case 1:
                        albit.setBirthDate((String) getCellValue(nextCell));
                        break;
//                    case 3:
//                        albit.setId((int) getCellValue(nextCell));
//                        break;
                }
            }
            list.add(albit);
        }
        testWorkbook.close();
        inputStream.close();
        return list;
    }

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }

}
