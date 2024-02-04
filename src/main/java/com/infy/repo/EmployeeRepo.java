package com.infy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> 
{

}
