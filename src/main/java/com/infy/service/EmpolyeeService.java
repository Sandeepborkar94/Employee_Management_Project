package com.infy.service;

import java.util.List;

import com.infy.dto.EmployeeDTO;
import com.infy.model.Employee;

public interface EmpolyeeService 
{
	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long id);

	public Employee createEmployee(EmployeeDTO employeeDTO);

	public Employee updateEmployee(Long id, EmployeeDTO employeeDTO);

	public void deleteEmployee(Long id);

}
