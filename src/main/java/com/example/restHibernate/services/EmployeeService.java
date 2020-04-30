package com.example.restHibernate.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restHibernate.entity.Employee;


public interface EmployeeService {

	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save (Employee theEmployee);
	public void deleteById(int theId);
	
}
