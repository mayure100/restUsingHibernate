package com.example.restHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.restHibernate.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDAO {

	//define field for entityManager
	private EntityManager entityManager;
	//setup constructor injection 
	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
	
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		//execute query and get result list
	  List<Employee> employees = theQuery.getResultList();
 		//return result
	  currentSession.close();
		return employees;
	}
	@Override
	public Employee findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee theEmployee = currentSession.get(Employee.class, theId);
		currentSession.close();
		return theEmployee;
	}
	@Override
	public void save(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.save(theEmployee);
		
	}
	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from employee where id=: employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		currentSession.close();
	}
	
	
	
	

}
