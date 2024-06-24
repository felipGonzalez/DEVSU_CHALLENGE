package com.devsu.accountservice.application;

import com.devsu.accountservice.application.dto.report.ReportMovementDto;

import java.time.ZonedDateTime;
import java.util.List;

public interface ReportService {

    List<ReportMovementDto> generateReport(String initDate, String clientId);

}
