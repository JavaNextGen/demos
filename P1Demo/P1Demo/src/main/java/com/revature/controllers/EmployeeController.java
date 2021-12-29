package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

import io.javalin.http.Handler;

public class EmployeeController {
	
	EmployeeService es = new EmployeeService();

	// *****This layer is where we'll parse our JSON into Java objects and vice vera*****
	// Sits between the Javalin Front Controller and the Service Layer
	// We'll either be getting data from the service layer (which is our DAO)
	// ORR sending data to the service layer (will probably return some response that it was successful)
	
	public Handler getEmployeesHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { //if the session exist
			
			List<Employee> allEmployees = es.getEmployees();
			
			// Add the dependency into your pom.xml so it can import the Gson library
			Gson gson = new Gson();
			
			// Use gson library to convert the java object to a JSON string
			String JSONEmployees = gson.toJson(allEmployees);
			
			// Give a response body with a JSON string 
			ctx.result(JSONEmployees);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	
}
