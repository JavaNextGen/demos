package com.revature.exceptions;

//Unchecked Exceptions aka Runtime Exceptions must extend RuntimeException
public class MyUncheckedException extends RuntimeException {

	//constructors-------- 
	
	//no args - this will call the constructor from Throwable because of super();
	public MyUncheckedException() {
		super(); 
	}
	
	//another constructor that will display an error message. 
	//It'll accept a message to display. There is one like this in Throwable as well, hence super(message);
	public MyUncheckedException(String message) {
		super(message);
	}

}
