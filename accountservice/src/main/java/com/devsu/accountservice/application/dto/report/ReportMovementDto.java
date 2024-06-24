package com.devsu.accountservice.application.dto.report;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class ReportMovementDto {

    private String fecha;
    private String cliente;
    private String numeroCuenta;

    private String tipo;

    private BigDecimal saldoInicial;

    private boolean estado;

    private BigDecimal movimiento;

    private BigDecimal saldoDisponible;

    public void addDate(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        fecha = date.format(formatter);
    }

}
