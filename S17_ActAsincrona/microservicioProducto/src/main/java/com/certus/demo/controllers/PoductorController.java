package com.certus.demo.controllers;

import com.certus.demo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/microservicio/server")
public class PoductorController {

	@GetMapping
	public String producto() {
		return "Este son los Productos ID, Nombre y Precio";
	}

	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck()
	{
		return "{ \"todoOk\" : true }";
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee("1","Avena","200"));
		employeesList.add(new Employee("2","Maiz","123"));
		return employeesList;
	}
}
