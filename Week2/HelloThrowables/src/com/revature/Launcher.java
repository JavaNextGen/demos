/**
 * 
 */
package com.revature;

import com.revature.exceptions.MyCheckedException;
import com.revature.exceptions.MyUncheckedException;

/**
 * @author BenjaminJosephPetruzziello
 *
 */
public class Launcher {
	
	public static void main(String[] args) {
		
		
		
	}
	
	
	
	//creating methods that throw our custom exceptions---------
	
	//checked exceptions NEED throws declarations to compile
	//remember they're CHECKED... the compiler checks for them and won't let you compile otherwise
	public static void throwChecked() throws MyCheckedException { 
		
		System.out.println("I'm about to throw a checked exception...");
		
		throw new MyCheckedException("Checked Exception Thrown"); //this throw declaration will throw our checked exception
		//note the new keyword - this is actually creating an object!
	}
	
	
	//the compiler doesn't check for unchecked exceptions... so we can compile without the throws declaration
	//but this will still crash the program at runtime! So we still need to add it.
	public static void throwUnchecked() {
		
		System.out.println("I'm about to throw an UNchecked exception...");
		
		throw new MyUncheckedException("Unchecked Exception Thrown");
		
	}

}
