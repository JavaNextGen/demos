package com.revature.services;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;

public class EmployeeService {

	EmployeeDAO eDAO = new EmployeeDAO(); //so that I can use the methods from the EmployeeDAO
	
	public void addEmployee(Employee newEmployee) {
		
		//take in the Employee object sent from the menu and send it to the EmployeeDAO to be inserted into the database
		
		//we need to actually write the DAO method that inserts the new Employee
		
	}
	
}
