package com.devsu.accountservice.infrastructure.configuration;

import com.devsu.accountservice.AccountserviceApplication;
import com.devsu.accountservice.application.AccountService;
import com.devsu.accountservice.application.AccountServiceImp;
import com.devsu.accountservice.domain.repository.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AccountserviceApplication.class)
public class BeanConfiguration {

    @Bean
    AccountService accountService(final AccountRepository accountRepository) {
        return new AccountServiceImp(accountRepository);
    }

}
