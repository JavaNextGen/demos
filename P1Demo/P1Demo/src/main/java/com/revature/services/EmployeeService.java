package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;

public class EmployeeService {

	EmployeeDAO eDAO = new EmployeeDAO(); //so that I can use the methods from the EmployeeDAO
	
	public List<Employee> getEmployees() {
		
		//get the List of Employees by calling the DAO method that selects them from the database
		List<Employee> employees = eDAO.getEmployees();
		
		//return the list of employees
		return employees;
	}
	
	public void addEmployee(Employee newEmployee) {
		
		//take in the Employee object sent from the menu and send it to the EmployeeDAO to be inserted into the database
		
		//call the DAO method that inserts the new Employee
		eDAO.insertEmployee(newEmployee);
	}

	//This is only returning one object so it doesn't necessarily have to be a list...
	public List<Employee> getEmployeeById(int idInput) {
		
		List<Employee> employee= eDAO.getEmployeeById(idInput);
		
		return employee;
	}

	public List<Employee> getEmployeesByRoleTitle(String roleInput) {
		
		List<Employee> employees = eDAO.getEmployeesByRoleTitle(roleInput);
		
		return employees;
	}
	
}
