package com.revature.services;

//probably would need to import some DAO class if we weren't hardcoding

public class AuthService {

	//hardcoding username/password - which you WON'T do in P1
	
	//Typically, you'll want to validate username/password against some username/password in the DATABASE.
	//So in your P1, you'd be sending the data sent into the LoginDTO... 
	//and most likely doing some DAO method that uses those values to check for matching values in the DB.
	//soooooo we probably need a DAO method that has something like: 
		//"select * from users where username = ? and password = ?" and then insert the values of the DTO for parameters
	
	public boolean login(String username, String password) {
		
		//this is hardcoding - telling Java exactly what values make for a valid login
		//in reality, you'll check the database for a username/password to see if a record exists
		if(username.equals("user") && password.equals("password")) {
			
			return true; //true indicates successful login
			
		}
		
		return false; //unsuccessful login
		
		
	}
	
}
