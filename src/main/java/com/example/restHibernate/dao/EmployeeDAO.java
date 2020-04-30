package com.example.restHibernate.dao;
import java.util.List;

import com.example.restHibernate.entity.*;
public interface EmployeeDAO {

	
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save (Employee theEmployee);
	public void deleteById(int theId);
	
	
	
}
