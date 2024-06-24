package com.devsu.accountservice.infrastructure.communication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.Duration;

@Service
@Slf4j
public class SyncRestService {

    private final WebClient webClient;

    @Autowired
    public SyncRestService(WebClient webClient) {
        this.webClient = webClient;
    }

    public <T> T getDataClient(String url,Class<T> responseType) {
        try {
            return this.webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(responseType)
                    .timeout(Duration.ofSeconds(10))
                    .block();
        } catch (WebClientResponseException e) {
            log.error("Error: " + e.getStatusCode());
            return null;
        }
    }
}