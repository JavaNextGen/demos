package com.revature.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeDAO {

	public List<Employee> getEmployees() { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String sql = "SELECT * FROM employees;";
			
			//Put the SQL query into a Statement object (The Connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The Statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(sql);
			
			//All the code above makes a call to your database... Now we need to store the data in an ArrayList.
			
			//create an empty ArrayList to be filled with the data from the database
			List<Employee> employeeList = new ArrayList<>();
			
			//while there are results in the resultset...
			while(rs.next()) {
				
				//Use the all args constructor to create a new Employee object from each returned row from the DB
				Employee e = new Employee(
						//we want to use rs.get for each column in the record
						rs.getInt("employee_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("role_id")
						);
				
				//and populate the ArrayList with each new Employee object
				employeeList.add(e); //e is the new Employee object we created above
		
			}
						
			//when there are no more results in rs, the while loop will break
			//then, return the populated ArrayList of Employees
			return employeeList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting employees!");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block, so Java won't yell
		//(Since there's no guarantee that the try will run)
		
	}
	
}
