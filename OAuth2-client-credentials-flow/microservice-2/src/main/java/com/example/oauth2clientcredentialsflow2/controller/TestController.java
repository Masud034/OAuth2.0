package com.example.oauth2clientcredentialsflow2.controller;


import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class TestController {
    private final WebClient webClient = WebClient.builder().build();

    @Autowired
    private Keycloak keycloak;

    @GetMapping(value = "/m2/test")
    public String callMicroservice2() {
        String authToken = keycloak.tokenManager().getAccessToken().getToken();
        System.out.println(authToken);
        return webClient.get()
                .uri("http://localhost:8084/m1/test")
                .headers(header -> header.setBearerAuth(authToken))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
