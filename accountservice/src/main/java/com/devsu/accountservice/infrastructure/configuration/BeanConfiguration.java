package com.devsu.accountservice.infrastructure.configuration;

import com.devsu.accountservice.AccountserviceApplication;
import com.devsu.accountservice.application.*;
import com.devsu.accountservice.domain.repository.AccountRepository;
import com.devsu.accountservice.domain.repository.ClientRepository;
import com.devsu.accountservice.domain.repository.MovementRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AccountserviceApplication.class)
public class BeanConfiguration {

    @Bean
    AccountService accountService(final AccountRepository accountRepository,
                                  final MovementRepository movementRepository,
                                  final ClientRepository clientRepository) {
        return new AccountServiceImp(accountRepository, movementRepository, clientRepository);
    }

    @Bean
    MovementService movementService(final MovementRepository movementRepository,
                                    final AccountRepository accountRepository) {
        return new MovementServiceImp(movementRepository, accountRepository);
    }

    @Bean
    ReportService reportService(final AccountRepository accountRepository,
                                 final MovementRepository movementRepository,
                                 final ClientRepository clientRepository) {
        return new ReportServiceImp(accountRepository, movementRepository, clientRepository);
    }

}
