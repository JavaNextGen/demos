package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.models.Menu;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		//instantiating controller objects to use their method
		EmployeeController ec = new EmployeeController();
		AuthController ac = new AuthController();
		
		
		//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
		//Here is the actual functionality of our application-------------------
		
		//spoiler alert... there will only be two lines of codes here
		
		
		//Instantiate a menu object
		// Menu menu = new Menu();
		
		//Use the Menu Class's displayMenu() method to give the user the menu
		// menu.displayMenu();
		
		
		//this^ was our entire main method, but now we're using Javalin below-------------------------

		Javalin app = Javalin.create(
					config -> {
						config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
					}
				).start(3000);
		
		//these are your Javalin endpoint handlers, which will take in requests and send them where they need to go
		
		//handler ending in /employee that takes GET requests - will return all Employees
		app.get("/employee", ec.getEmployeesHandler);
		
		//handler ending in /employee that takes POST requests -  will let us insert employees
		app.post("/employee", ec.insertEmployeeHandler);
		
		//handler ending in /login to send and inputted username/password to be validated
		app.post("/login", ac.loginHandler);
		
	}

}
