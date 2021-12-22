package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>This ConnectionFactory class follows the Singleton Design Pattern and facilitates obtaining a connection to a Database for the ERS application.</p>
 * <p>Following the Singleton Design Pattern, the provided Constructor is private, and you obtain an instance via the {@link ConnectionFactory#getInstance()} method.</p>
 */

//This Class contains the java logic that gets a connection to our database
//It will have a method called getConnection() which will return a Connection object
//We will need this Connection object in our repository package to interact with our database
public class ConnectionFactory {
	
    private static ConnectionFactory instance;

    private ConnectionFactory() {
        super();
    }

    /**
     * <p>This method follows the Singleton Design Pattern to restrict this class to only having 1 instance.</p>
     * <p>It is invoked via:</p>
     *
     * {@code ConnectionFactory.getInstance()}
     */
    public static ConnectionFactory getInstance() {
        if(instance == null) {
            instance = new ConnectionFactory();
        }

        return instance;
    }

    /**
     * <p>The {@link ConnectionFactory#getConnection()} method is responsible for leveraging a specific Database Driver to obtain an instance of the {@link java.sql.Connection} interface.</p>
     * <p>Typically, this is accomplished via the use of the {@link java.sql.DriverManager} class.</p>
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        
    	//For compatibility with other technologies, we need to register our PostgreSQL Driver
    	//This process makes the application aware of what database Driver (SQL dialect) we're using
    	try {
    		Class.forName("org.postgresql.Driver"); //try to find and return the psotgresql Driver Class
    	} catch (ClassNotFoundException e) {
    		System.out.println("CLASS WASN'T FOUND");
    		e.printStackTrace(); //this will print the exception message to the console
    	}
    	
    	//we need to provide our database credentials
    	//we'll hardcode them for now, but I'll show a way to hide the credentials in environment variables
    	
    	//the url to my database schema
    	String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=p1demo";
    	//your postgres username (should just be postgres)
    	String username = "postgres";
    	//your postgres password (hopefully just "password")
    	String password = "Sparky2014!!"; //don't be like me
    
    	//This is what actually returns our Connection object. (Note how this method has a return type of Connection)
    	return DriverManager.getConnection(url, username, password);
    	
    }
}
