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
    public String hola() {
        String url ="http://demo-eureka-servicio/rest/hola/server";
        //String url ="http://localhost:8071/rest/hola/server";
        //return restTemplate.getForObject(url,String.class);
        return cbFactory.create("mensajes")
                .run(()-> restTemplate.getForObject(url,String.class), e -> metodoAlternativo(e));
    }

    public String metodoAlternativo(Throwable e) {
        String url ="http://demo-eureka-respaldo/rest/hola/server";
        return  restTemplate.getForObject(url,String.class);
    }

}


