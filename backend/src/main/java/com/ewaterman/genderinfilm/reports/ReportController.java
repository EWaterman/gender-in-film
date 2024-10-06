package com.ewaterman.genderinfilm.reports;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/primary")
    public ResponseEntity<ReportDto> generatePrimaryReport() {
        return ResponseEntity.ok(reportService.generatePrimaryReport());
    }
}
