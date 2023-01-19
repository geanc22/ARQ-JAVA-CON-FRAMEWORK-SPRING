package com.certus.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/microservicio/server")
public class PoductorController {

	@GetMapping
	public String hola() {
		return "Servicio de Respaldo de Productos";
	}
}
