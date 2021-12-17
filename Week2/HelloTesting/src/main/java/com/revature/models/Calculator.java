package com.revature.models;

public class Calculator {

	//we're going to make 3 super simple methods to write unit tests for
	//remember, unit tests tend to test the smallest possible blocks of code (usually methods)
	
	//addition method
	public int add(int x, int y) {
		return x + y;
	}
	
	//subtraction method
	public int subtract(int x, int y) {
		return x - y;
	}
	
	//division method
	public int divide(int x, int y) {
		return x / y;
	}

}
