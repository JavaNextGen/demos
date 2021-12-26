package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.repositories.EmployeeDAO;
import com.revature.services.EmployeeService;
import com.revature.services.RoleService;

//This Menu Class will have a displayMenu() method that displays the menu to the user and lets them interact with it
//The menu will make use of the Scanner class to take user inputs in order to travel through the menu options.
public class Menu {

	EmployeeService es = new EmployeeService(); //we need this object to use methods from EmployeeService
	RoleService rs = new RoleService();
	
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
			System.out.println("employeesByTitle -> get employees of a certain title");
			System.out.println("add -> add a new employee");
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
				List<Employee> employees = es.getEmployees();
				
				//enhanced for loop to print out the Employees one by one
				for (Employee e : employees) {
					System.out.println(e);
				}
				
				break;
			}
			
			case "employeesById" :{
				System.out.println("What employee id would you like to search for?");
				
				int idInput = scan.nextInt(); //get user's input for id
				scan.nextLine(); //we still need nextLine so that we can move to the next line for more input
				
				//what if the user inputs a String? program crashes
				//up to you to polish your project a bit and add some foolproofing mechanisms
				
				List<Employee> employees = es.getEmployeeById(idInput);
				
				for(Employee emp : employees) {
					System.out.println(emp);
				}
				
				break;
			}
			
			case "employeebytitle": {
				
			System.out.println("Enter Employee Role to Search: (Case Sensitive! e.g. \"Fry Cook\")");
			String roleInput = scan.nextLine(); //get user's input for Role to search by
			
			List<Employee> employees = es.getEmployeesByRoleTitle(roleInput); //get the List of Employees from the dao
			
			for(Employee e : employees)
			{
				System.out.println(e); //print them out one by one via the enhanced for loop
			}
			break;				
			
		}
			
			case "add" : {
				
				//we need to prompt the user for the employee's name, and their role_id
				System.out.println("Enter Employee First Name");
				String f_name = scan.nextLine();
				
				System.out.println("Enter Employee Last Name");
				String l_name = scan.nextLine();
				
				System.out.println("Enter Role Id: 1) Manager 2) Fry Cook 3) Cashier 4) Marketing 5) Nepotism");
				int roleId = scan.nextInt(); //we need nextInt because ID is an int datatype in the database
				scan.nextLine(); //without any nextLine(), your enter keystroke will be grabbed as the next input
				//so we need nextLine() in order to actually move to the..... NEXT line!
				
				//Given all this information, we'll create a new Employee object to send to the service layer
				//then the service layer will send it to the repository layer.
				Employee newEmployee = new Employee(f_name, l_name, roleId);
				
				//Put the new Employee into the addEmployee() method in the EmployeeService Class
				es.addEmployee(newEmployee);
				
				break;
			}
				
				case "updateSalary": {
				
				System.out.println("Enter Role Title to change");
				String titleInput = scan.nextLine();
				
				System.out.println("Enter a new Salary for this Role");
				int salaryInput = scan.nextInt();
				scan.nextLine();
				
				rs.updateSalary(titleInput, salaryInput);
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
