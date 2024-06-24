package com.devsu.accountservice.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class MovementResponseDTO {

    private Long id;
    private String accountId;
    private String date;
    private String accountType;
    private String movementType;
    private BigDecimal amount;
    private BigDecimal balance;

    public void addDate(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = date.format(formatter);
    }

}
