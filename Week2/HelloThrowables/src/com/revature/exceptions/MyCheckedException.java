package com.revature.exceptions;

//This is a checked/compile time exception, so we have to extend Exception
@SuppressWarnings("serial") //not necessary, but removes the warning
public class MyCheckedException extends Exception{

	//see MyUncheckedException to find out what this constructor is doing
	public MyCheckedException(String message) {
		super(message);
	}
	
}
