package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.EmployeeController;
import com.revature.models.Menu;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		EmployeeController ec = new EmployeeController();
		
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
		
		
		app.get("/employee", ec.getEmployeesHandler);
		
		
		app.post("/employee", ec.insertEmployeeHandler);
		
		
	}

}
