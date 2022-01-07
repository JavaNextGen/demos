package com.revature.models;

//What da HECK is a DTO? Data Transfer Object. A DTO is just a model of /some/ data coming from the client (front end)
//An HTTP handler will parse a JSON object sent by the user, containing their username and password
//this then gets sent to the controller to get turned into a Java object (using Gson)
//The username and password will then be put into the DTO as fields (see fields below), which get checked by the service
//You NEVER store a DTO in the database. It's purely for data transfer... we're transferring the username/password 
public class LoginDTO {

	//our LoginDTO models ONLY the username/password of our users
	private String username;
	private String password;

	
	//Then I just want two constructors so we can instantiate this class and transfer data with it
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	//and then getters/setters to access our fields

	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	

	//toString just incase we want to print out the object (could be helpful for debug)
	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", password=" + password + "]";
	}
	
	
	
}
