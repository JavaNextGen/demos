package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.repositories.EmployeeDAO;

//This Menu Class will have a displayMenu() method that displays the menu to the user and lets them interact with it
//The menu will make use of the Scanner class to take user inputs in order to travel through the menu options.
public class Menu {

	EmployeeDAO eDAO = new EmployeeDAO(); //we need this object to use methods from EmployeeDAO
	
	//All of the menu display options and control flow are contained within this method
	public void displayMenu() {
		
		boolean displayMenu = true; //we're going to use this to toggle whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //Scanner object to parse (take) user input
		
		//give the user a pretty greeting :)
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println("Welcome to The Krusty Krab Employee Management System");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		
		
		//display the menu as long as the displayMenu boolean == true
		//this is going to hold and display all my menu options until displayMenu == false
		while(displayMenu) { 
			
			//menu options
			System.out.println("hi -> get greeted");
			System.out.println("employees -> show all employees");
			System.out.println("employeesById -> get employees with a certain ID");
			System.out.println("exit -> exit the application");
			
			
			//parse user input after they choose a menu option, and put it into a String variable
			String input = scan.nextLine();
			
			//switch statement that takes the user input and executes the appropriate code
			//BEN MAY ADD MORE COMMENTS HERE ONCE WE DO DATABASE CONNECTIVITY
			switch(input) {
			
			case "hi": {
				System.out.println("Hello there.");
				break; //we need a break in each case block, or else all the other cases will still run
			}
			
			case "employees" :{
				
				//get the List of employees from the repository layer
				List<Employee> employees = eDAO.getEmployees();
				
				//enhanced for loop to print out the Employees one by one
				for (Employee e : employees) {
					System.out.println(e);
				}
				
				break;
			}
			
			case "employeesById" :{
				System.out.println("functionality tbd");
				break;
			}
			
			case "exit": {
				displayMenu = false;
				break;
			}
			
			//this default block will catch any user inputs that don't match a valid menu option
			default: {
				System.out.println("Invalid selection... try again :'( ");
				break;
			}
			
			
			} //end of switch
			
		} //end of while loop
		
		
	}
	
}
