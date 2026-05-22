package com.duoc.vrk.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class ExternalVRKService {

    private static final Logger logger = LoggerFactory.getLogger(ExternalVRKService.class);

    @Autowired
    private WebClient webClient;

    public List<Object> getExternalTracks() {
        logger.info("Solicitando pistas de musica externas vía WebClient...");
        try {
            return webClient.get()
                    .uri("/posts")
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<Object>>() {})
                    .block();
        } catch (Exception e) {
            logger.error("Error al conectar con el servicio externo: {}", e.getMessage());
            return List.of();
        }
    }
}