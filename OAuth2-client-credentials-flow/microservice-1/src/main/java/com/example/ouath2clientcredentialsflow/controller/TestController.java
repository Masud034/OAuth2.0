package com.example.ouath2clientcredentialsflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/m1/test")
    public String testClientCredsFlow() {
        return "Hello There, I am microservice-1. Accessed through microservice-2";
    }
}
