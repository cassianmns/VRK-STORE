package com.duoc.robloxmusic.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        // API externa de prueba
        return builder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }
}