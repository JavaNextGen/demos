package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

import io.javalin.http.Handler;

public class EmployeeController {
	
	EmployeeService es = new EmployeeService();

	// *****This layer is where we'll parse our JSON into Java objects and vice versa*****
	// Sits between the Javalin Front Controller and the Service Layer
	// We'll either be getting data from the service layer (which is our DAO)
	// ORR sending data to the service layer (will probably return some response that it was successful)
	
	public Handler getEmployeesHandler = (ctx) -> {
		if(ctx.req.getSession(false) != null) { //if the session exists
			
			List<Employee> allEmployees = es.getEmployees();
			
			// Add the dependency into your pom.xml so it can import the Gson library
			Gson gson = new Gson();
			
			// Use gson library to convert the java object to a JSON string
			String JSONEmployees = gson.toJson(allEmployees);
			
			// Give a response body with a JSON string 
			ctx.result(JSONEmployees);
			ctx.status(200);
			

		} else {
			ctx.result("Not logged in - can't access employees!");
			ctx.status(401);
		}
	};
	
	public Handler insertEmployeeHandler = (ctx) -> {
		
		if(ctx.req.getSession(true) != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Employee employee = gson.fromJson(body, Employee.class);
			
			es.addEmployee(employee);
			
			ctx.result("Employee was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Not logged in - can't insert employees!");
			ctx.status(404);
		}
		
		
	};
	
}
