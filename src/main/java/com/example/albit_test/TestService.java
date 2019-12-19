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
        String filePath = "C:\\Users\\HANGYEOL\\Desktop\\springboot_excel_parse\\src\\main\\resources\\static\\albit_sample_data.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        Workbook testWorkbook = WorkbookFactory.create(inputStream);
        Sheet firstSheet = testWorkbook.getSheetAt(0);

        Iterator<Row> rowIterator = firstSheet.iterator();

        while (rowIterator.hasNext()) {
            Albit albit = new Albit();
            Row nextRow = rowIterator.next();
            // 첫 번째 행이 헤더인 경우 스킵, 2번째 행부터 data 로드
            if (nextRow.getRowNum() <= 1) {
                continue;
            }

            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 0:
                        Double periodValue = ((Double) getCellValue(nextCell));
                        if (periodValue.toString().equals("-")) {
                            periodValue = (double) 0;
                        }
                        albit.setPeriod(periodValue.intValue());
                        break;
                    case 1:
                        Double usingRateValue = ((Double) getCellValue(nextCell));
                        if (usingRateValue.toString().equals("-")) {
                            usingRateValue = (double) 0;
                        }
                        albit.setUsing_rate(usingRateValue);
                        break;
                    case 2:
                        Double smartPhoneValue = ((Double) getCellValue(nextCell));
                        if (smartPhoneValue.toString().equals("-")) {
                            smartPhoneValue = (double) 0;
                        }
                        albit.setSmart_phone(smartPhoneValue);
                        break;
                    case 3:
                        Double desktopComputerValue = ((Double) getCellValue(nextCell));
                        if (desktopComputerValue.toString().equals("-")) {
                            desktopComputerValue = (double) 0;
                        }
                        albit.setDesktop_computer(desktopComputerValue);
                        break;
                    case 4:
                        Double notebookComputerValue = ((Double) getCellValue(nextCell));
                        if (notebookComputerValue.toString().equals("-")) {
                            notebookComputerValue = (double) 0;
                        }
                        albit.setNotebook_computer(notebookComputerValue);
                        break;
                    case 5:
                        Double etcValue = ((Double) getCellValue(nextCell));
                        if (etcValue.toString().equals("-")) {
                            etcValue = (double) 0;
                        }
                        albit.setEtc(etcValue);
                        break;
                    case 6:
                        String smartPadValue = String.valueOf(getCellValue(nextCell));
                        Double returnValue = 0.0;
                        if (smartPadValue.equals("-")) {
                            smartPadValue = String.valueOf(0.0);
                            returnValue = Double.valueOf(smartPadValue);
                            System.out.println(smartPadValue);
                        }

                        albit.setSmart_pad(Double.valueOf(smartPadValue));
                        break;

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