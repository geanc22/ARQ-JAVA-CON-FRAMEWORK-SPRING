package com.certus.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/rest/hola/client")
public class ConsumidorController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory cbFactory;

    @GetMapping
    public String producto() {
        String url ="http://demo-eureka-producto/rest/microservicio/server";

        return cbFactory.create("mensajes")
                .run(()-> restTemplate.getForObject(url,String.class), e -> metodoAlternativo(e));
    }

    public String metodoAlternativo(Throwable e) {
        String url ="http://demo-eureka-respaldo/rest/microservicio/server";
        return  restTemplate.getForObject(url,String.class);
    }

}


