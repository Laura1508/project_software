package com.api.reporte_financiero.controller;

import com.api.reporte_financiero.service.ReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/report")
public class UpLoadCSV {

    private final ReportService reportService;

    public UpLoadCSV(ReportService reportService) {
        this.reportService = reportService;
    }

    // Endpoint para subir archivo CSV y generar PDF
        @PostMapping("/upload")
        public ResponseEntity<byte[]> uploadCSV(@RequestParam("file") MultipartFile file) {
            try {
                byte[] pdf = reportService.processFile(file);

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf")
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(pdf);

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        }
    }
