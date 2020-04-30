package com.example.restHibernate.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.restHibernate.entity.*;
import com.example.restHibernate.services.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	@GetMapping("employees")
	public List<Employee> findAllEmployees(){
		
		return employeeService.findAll() ;
		}
	
	@GetMapping("employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
			if(theEmployee == null) {
				throw new RuntimeException("Employee not found " + employeeId);
			}
		
		return theEmployee;
		
		}
	
	
	@PostMapping(path="/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(1);
	
		employeeService.save(theEmployee);
		return theEmployee;
		}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
		
		}
	@DeleteMapping("/employees/{employeeId}")
	public void delete(@PathVariable int employeeId ) {
		
	Employee emp = 	employeeService.findById( employeeId);
	if(emp!=null) {	
	employeeService.deleteById(employeeId);
	}else {
		System.out.println("id not found");
	}
	}
	
}
