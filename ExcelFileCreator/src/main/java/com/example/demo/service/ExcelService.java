package com.example.demo.service;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Service
public class ExcelService {

    public void importDataFromExcel(MultipartFile file) throws IOException {
        try (InputStream excelFile = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.iterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    // Process each cell as needed
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
        }
    }
}
