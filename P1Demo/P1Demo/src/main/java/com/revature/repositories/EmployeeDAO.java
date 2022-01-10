package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	//Bit more complicated query - using PARAMETERS to SELECT records WHERE employee_id = ?
	public List<Employee> getEmployeeById(int id) {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select * from employees where employee_id = ?";
			
			//when we need parameters we need to use a PREPARED Statement, as opposed to a Statement (seen above)
			PreparedStatement ps = conn.prepareStatement(sql); //prepareStatment() as opposed to createStatment()
			
			//insert the methods argument (int id) as the first (and only) variable in our SQL query
			ps.setInt(1, id); //the 1 here is referring to the first parameter (?) found in our SQL String
			
			rs = ps.executeQuery();
			
			//create an empty List to be filled with the data from the database
			List<Employee> employeeList = new ArrayList<>();
			
	//we technically don't need this while loop since we're only getting one result back... see if you can refactor :)
			while(rs.next()) { //while there are results in the result set...
				
			//Use the all args Constructor to create a new Employee object from each returned row...
			Employee e = new Employee(
					//we want to use rs.getXYZ for each column in the record
					rs.getInt("employee_id"),
					rs.getString("f_name"),
					rs.getString("l_name"),
					rs.getInt("role_id")
					);
			
			//and populate the ArrayList with each new Employee object
			employeeList.add(e); //e is the new Employee object we created above
			}
			
			//when there are no more results in the ResultSet the while loop will break...
			//return the populated List of Employees
			return employeeList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with your database!"); 
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public void insertEmployee(Employee newEmployee) { //This is INSERT functionality 
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			//we'll create a SQL statement using parameters to insert a new Employee
			String sql = "INSERT INTO employees (f_name, l_name, role_id) " //creating a line break for readability
					    + "VALUES (?, ?, ?); "; //these are parameters!! We have to specify the value of each "?"
			
			PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
			
			//use the PreparedStatement objects' methods to insert values into the query's ?s
			//the values will come from the Employee object we send in.
			ps.setString(1, newEmployee.getF_name()); //1 is the first ?, 2 is the second, etc.
			ps.setString(2, newEmployee.getL_name());
			ps.setInt(3, newEmployee.getRole_id());
			
			//this executeUpdate() method actually sends and executes the SQL command we built
			ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
			//we use executeQuery() for selects
			
			//send confirmation to the console if successul.
			System.out.println("Employee " + newEmployee.getF_name() + " created. Welcome aboard!");
			
			
		} catch(SQLException e) {
			System.out.println("Add employee failed! :(");
			e.printStackTrace();
		}
		
	}
	
	
		//Bit more complicated query, uses a join to get more data than usual from two tables 
		public List<Employee> getEmployeesByRoleTitle(String title) {
			
			try(Connection conn = ConnectionFactory.getConnection()){
				
				ResultSet rs = null;
				
				String sql = "select * from employees inner join roles "
						     + "on employees.role_id = roles.role_id where roles.role_title = ?";
				//we need to join employees to roles in order to access the role_title column and return employees
				//since I want to get employees based on something found in the roles table, we need a join 
				
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, title); //insert the method's argument as the first (and only) variable in the query
				
				rs = ps.executeQuery();	
				
				List<Employee> employeeList = new ArrayList<>();
				
				while(rs.next()) { //while there are results in the result set...
					
					Employee e = new Employee( //create a new Employee Object from each returned row..
							rs.getInt("employee_id"),
							rs.getString("f_name"),
							rs.getString("l_name"),
							rs.getInt("role_id")
							);
					
					employeeList.add(e); //and populate the ArrayList with each created Role Object
				}
				
				return employeeList; //Finally, return the populated List of Roles.
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	
	
	
}
