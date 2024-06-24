package com.devsu.accountservice.infrastructure.rest;

import com.devsu.accountservice.application.ReportService;
import com.devsu.accountservice.application.dto.report.ReportMovementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/reportes")
@CrossOrigin("*")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping()
    public ResponseEntity<List<ReportMovementDto>> getReport(@RequestParam String date,@RequestParam String clientId) {
        List<ReportMovementDto> movements = reportService.generateReport(date,clientId);
        return ResponseEntity.ok(movements);
    }
   }
