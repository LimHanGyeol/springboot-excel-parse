package com.example.albit_test;

import com.example.albit_test.model.Albit;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AlbitService {

    private String smartPadValue, etcValue, notebookComputerValue, desktopComputerValue, smartPhoneValue, usingRateValue;
    private Double periodValue;
    private List<Albit> list;

    @Autowired
    private AlbitRepository albitRepository;

    public List<Albit> readExcelFile() throws IOException {
        list = new ArrayList<>();
        String filePath = "C:\\Users\\HANGYEOL\\Desktop\\springboot_excel_parse\\src\\main\\resources\\static\\albit_sample_data.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        Workbook testWorkbook = WorkbookFactory.create(inputStream);
        Sheet firstSheet = testWorkbook.getSheetAt(0);

        Iterator<Row> rowIterator = firstSheet.iterator();
        getRowData(rowIterator);
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

    private Double indexDataVaild(String value) {
        if (value.equals("-")) {
            value = String.valueOf(0.0);
        }
        return Double.valueOf(value);
    }

    private void getRowData(Iterator<Row> rowIterator) {
        while (rowIterator.hasNext()) {
            Row nextRow = rowIterator.next();
            if (nextRow.getRowNum() <= 1) {         // 헤더가 있을 경우 스킵, 값이 있는 행부터 data 로드
                continue;
            }
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            getCellData(cellIterator);
            Albit albit = new Albit(periodValue.intValue(), indexDataVaild(usingRateValue), indexDataVaild(smartPhoneValue), indexDataVaild(desktopComputerValue), indexDataVaild(notebookComputerValue), indexDataVaild(etcValue), indexDataVaild(smartPadValue));
            list.add(albit);
            albitRepository.save(albit);
        }
    }

    private void getCellData(Iterator<Cell> cellIterator) {
        while (cellIterator.hasNext()) {
            Cell nextCell = cellIterator.next();
            int columnIndex = nextCell.getColumnIndex();
            getCellDataParse(columnIndex, nextCell);
        }
    }

    private void getCellDataParse(int columnIndex, Cell nextCell) {
        switch (columnIndex) {
            case 0:
                periodValue = ((Double) getCellValue(nextCell));
                if (periodValue.toString().equals("-")) {
                    periodValue = (double) 0;
                }
                break;
            case 1:
                usingRateValue = String.valueOf(getCellValue(nextCell));
                break;
            case 2:
                smartPhoneValue = String.valueOf(getCellValue(nextCell));
                break;
            case 3:
                desktopComputerValue = String.valueOf(getCellValue(nextCell));
                break;
            case 4:
                notebookComputerValue = String.valueOf(getCellValue(nextCell));
                break;
            case 5:
                etcValue = String.valueOf(getCellValue(nextCell));
                break;
            case 6:
                smartPadValue = String.valueOf(getCellValue(nextCell));
                break;
        }
    }

}
