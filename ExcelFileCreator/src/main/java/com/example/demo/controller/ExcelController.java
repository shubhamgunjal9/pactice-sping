package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ExcelService;

import java.io.IOException;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/import/excel")
    public String importExcel(@RequestParam("file") MultipartFile filePath) {
        try {
            excelService.importDataFromExcel(filePath);
            return "Excel data imported successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error importing Excel data: " + e.getMessage();
        }
    }
}
