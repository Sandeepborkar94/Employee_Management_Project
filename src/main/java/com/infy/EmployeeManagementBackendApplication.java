package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EmployeeManagementBackendApplication
{
	@GetMapping(value = "/")
	public String home() 
	{
		return "Employee Management System";
		
	}


	public static void main(String[] args)
	{
		SpringApplication.run(EmployeeManagementBackendApplication.class, args);
		
		System.out.println("******************Aplication Running *****************");
	}
	
	
}
