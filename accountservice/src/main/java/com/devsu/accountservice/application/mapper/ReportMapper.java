package com.devsu.accountservice.application.mapper;

import com.devsu.accountservice.application.dto.report.ReportMovementDto;
import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.model.Client;
import com.devsu.accountservice.domain.model.Movement;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ReportMapper {

    public static ReportMovementDto toReportDto(Movement movement,
                                                Client client) {
        ReportMovementDto reportDto = new ReportMovementDto();
        reportDto.setCliente(client.getName());
        reportDto.setNumeroCuenta(movement.getAccountId());
        reportDto.setTipo(movement.getTypeAccountValue());
        reportDto.setSaldoInicial(movement.getInitialBalance());
        reportDto.setEstado(movement.getStatusAccount());
        reportDto.setMovimiento(movement.getAmount());
        reportDto.setSaldoDisponible(movement.getBalance());
        reportDto.addDate(movement.getDate());
        return reportDto;
    }
}
