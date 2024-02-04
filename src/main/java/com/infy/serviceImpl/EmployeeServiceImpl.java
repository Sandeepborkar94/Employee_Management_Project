package com.infy.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.EmployeeDTO;
import com.infy.exception.EmployeeNotFoundException;
import com.infy.model.Employee;
import com.infy.repo.EmployeeRepo;
import com.infy.service.EmpolyeeService;

@Service
public class EmployeeServiceImpl implements EmpolyeeService
{

	private EmployeeRepo employeeRepo;

	@Autowired	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) 
	{
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) 
	{
		// TODO Auto-generated method stub
		return employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
	}

	@Override
	public Employee createEmployee(EmployeeDTO employeeDTO)
	{
		Employee employee = new Employee();
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setMobile(employeeDTO.getMobile());
		employee.setAddress(employeeDTO.getAddress());
		
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) 
	{
		Employee existingEmp = getEmployeeById(id);
		
		existingEmp.setFirstName(employeeDTO.getFirstName());
		existingEmp.setLastName(employeeDTO.getLastName());
		existingEmp.setMobile(employeeDTO.getMobile());
		existingEmp.setAddress(employeeDTO.getAddress());
		
		return employeeRepo.save(existingEmp);
	}

	@Override
	public void deleteEmployee(Long id) 
	{
		// TODO Auto-generated method stub
		
		employeeRepo.deleteById(id);
		
	}
	
	
	
	
	
//	private final EmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
//
//    public Employee getEmployeeById(Long id) {
//        return employeeRepository.findById(id)
//                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
//    }
//
//    public Employee createEmployee(EmployeeDTO employeeDTO) {
//        Employee employee = new Employee();
//        employee.setFirstName(employeeDTO.getFirstName());
//        employee.setLastName(employeeDTO.getLastName());
//        return employeeRepository.save(employee);
//    }
//
//    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
//        Employee existingEmployee = getEmployeeById(id);
//        existingEmployee.setFirstName(employeeDTO.getFirstName());
//        existingEmployee.setLastName(employeeDTO.getLastName());
//        return employeeRepository.save(existingEmployee);
//    }
//
//    public void deleteEmployee(Long id) {
//        employeeRepository.deleteById(id);
//    }

}
