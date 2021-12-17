package com.revature.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import vs import static? In this case, we need to import the static members of the Assertions class
//if you're importing a static member, you need a static import

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.BeforeAll;  ***People with JUnit 5 can use this

public class CalculatorTests {

	//create a uninitialized Calculator object
	public static Calculator c; //uninitialized AKA no value given yet.
	
	//make a couple variables to use in our tests
	public int i = 3;
	public int j = 15;
	public int k = 0;
	public int result; //leave this uninitialized for now
	
	
	//@Before - you would use this annotation if you were in JUnit 4
	@BeforeAll //This method will run BEFORE the test class does any tests.
	public static void createCalc() {
		c = new Calculator();
		System.out.println("In the @BeforeAll method");
	}
	
	//@After - you would use this annotation if you were in JUnit 4
	@AfterAll //used for things you want to happen AFTER the test methods all complete
	public static void clearCalc() {
		c = null;
		System.out.println("In the @AfterAll method");
	}
	
	
	
	//Now let's actually write some unit tests--------------------------
	
	//*TO RUN A TEST CLASS: right click the class -> run as -> JUnit test
	
	@Test //We need this annotation for the method to be recognized as a test
	public void testAdd() {
		System.out.println("TESTING ADD METHOD");
		
		result = c.add(i, j); //we're assigning the result of the .add() method in Calculator to this "result" field.
		
		assertTrue(result == 18); //assertTrue() makes a test pass if the expression resolves to "true"
		//If the result variable is equivalent to 18, the test will pass.
		
	}
	
	
	@Test
	public void testSubtract() {
		System.out.println("TESTING SUBTRACT METHOD");
		
		result = c.subtract(i, j);
		
		assertEquals(-12, result); //takes two parameters, and checks their equality
		//if -12 is equivalent to the value of the result variable, this test passes
		
	}
	
	
	@Test
	public void testDivideByZeroThrowsException() {
		System.out.println("TRYING TO DIVIDE BY ZERO");
		
		assertThrows(ArithmeticException.class, () -> c.divide(i, k));
		//"assert that dividing by zero throws an ArithmeticException"
		//we're using a lambda here: (parameters) -> [some functionality]
			//it's a quick and easier route than using methods...
			//I don't like them that much, but some Java structures like assertThrows require them.
	}
	
}
