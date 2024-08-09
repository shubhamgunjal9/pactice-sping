package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ExcelService;
import com.example.service.SmartArtNode;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @GetMapping("/download/users.xlsx")
    public ResponseEntity<InputStreamResource> excelStudentReport() throws IOException {
        ByteArrayInputStream in = excelService.getSmartArt();

        // Prepare response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
}
