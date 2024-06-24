package com.devsu.accountservice.application;

import com.devsu.accountservice.application.dto.report.ReportMovementDto;
import com.devsu.accountservice.application.mapper.ReportMapper;
import com.devsu.accountservice.domain.DomainException;
import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.model.Client;
import com.devsu.accountservice.domain.model.Movement;
import com.devsu.accountservice.domain.repository.AccountRepository;
import com.devsu.accountservice.domain.repository.ClientRepository;
import com.devsu.accountservice.domain.repository.MovementRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ReportServiceImp implements ReportService{

    private static final ZoneId BOGOTA_ZONE = ZoneId.of("America/Bogota");
    private final AccountRepository accountRepository;
    private final MovementRepository movementRepository;

    private final ClientRepository clientRepository;

    public ReportServiceImp(AccountRepository accountRepository, MovementRepository movementRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.movementRepository = movementRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ReportMovementDto> generateReport(String initDate, String clientId) {
        LocalDateTime date = parseDate(initDate);
        Client client = validateClient(clientId);
        return generateReportForClient(client, date);
    }

    private static LocalDateTime parseDate(String initDate) {
        if (initDate == null || initDate.isBlank()){
            throw new DomainException("la fecha es obligatoria");
        }
        try {
            initDate = initDate.concat(" 00:00");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            return LocalDateTime.parse(initDate, formatter);
        } catch (DateTimeParseException e) {
            throw new DomainException("Formato de fecha incorrecto. Se espera dd-MM-yyyy "+ initDate);
        }
    }

    private Client validateClient(String clientId) {
        if (clientId == null || clientId.isBlank()){
            throw new DomainException("El clientId es obligatorio");
        }
        Optional<Client> clientOptional = clientRepository.findByClientId(clientId);
        return clientOptional.orElseThrow(() -> new DomainException("No se encontró ningún cliente con el clientId: " + clientId));
    }

    private List<ReportMovementDto> generateReportForClient(Client client,
                                                            LocalDateTime date) {

        List<Movement> movements = movementRepository.findByClientIdAndDateAfter(client.getClientId(),
                date);
        return movements.stream()
                .map(movement -> ReportMapper.toReportDto(movement, client))
                .toList();
    }
}
