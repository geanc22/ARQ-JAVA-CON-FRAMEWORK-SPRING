package com.certus.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioItemApplication.class, args);
    }

}
