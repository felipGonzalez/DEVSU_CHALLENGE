package com.devsu.customerservice.infrastructure.configuration;

import com.devsu.customerservice.CustomerserviceApplication;
import com.devsu.customerservice.application.ClientService;
import com.devsu.customerservice.application.ClientServiceImp;
import com.devsu.customerservice.application.mapper.ClientMapper;
import com.devsu.customerservice.domain.repository.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CustomerserviceApplication.class)
public class BeanConfiguration {

    @Bean
    ClientService clientService(final ClientRepository clientRepository) {
        return new ClientServiceImp(clientRepository);
    }

}
