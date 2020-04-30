package com.example.restHibernate.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;



import com.example.restHibernate.dao.EmployeeDAO;
import com.example.restHibernate.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDao;
	
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDao) {
		employeeDao= theEmployeeDao;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeDao.deleteById(theId);
	}

}
