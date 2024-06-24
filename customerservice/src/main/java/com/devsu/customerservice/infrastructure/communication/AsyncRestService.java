package com.devsu.customerservice.infrastructure.communication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Slf4j
public class AsyncRestService {

    private final WebClient webClient;

    @Autowired
    public AsyncRestService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void deleteSyncData(String endpoint) {
        try {
            this.webClient.delete()
                    .uri(endpoint)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(10))
                    .block();  // Bloquea hasta recibir la respuesta
        } catch (WebClientResponseException e) {
            log.error("Error: " + e.getStatusCode());
        }
    }
}
