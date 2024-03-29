x   package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.EmployeeDTO;
import com.infy.model.Employee;
import com.infy.service.EmpolyeeService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/employees")
public class EmployeeController
{
	private final EmpolyeeService employeeService;

	@Autowired
	public EmployeeController(EmpolyeeService empolyeeService) 
	{
		super();
		this.employeeService = empolyeeService;
	}
//get all employees
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	//get all employee by id
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
	{
		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	//post a employee
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Validated @RequestBody EmployeeDTO employeeDTO) 
	{
		Employee createdEmployee = employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}

	//update all employees
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
			@Validated @RequestBody EmployeeDTO employeeDTO)
	{
		Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	//delete all employees
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id)
	{
		employeeService.deleteEmployee(id);
		
		System.out.println(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
