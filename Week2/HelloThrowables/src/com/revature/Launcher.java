/**
 * 
 */
package com.revature;

import java.util.Scanner;

import com.revature.exceptions.MyCheckedException;
import com.revature.exceptions.MyUncheckedException;

/**
 * @author BenjaminJosephPetruzziello
 *
 */
public class Launcher {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws MyCheckedException {
		
		//throwUnchecked(); //the compiler will let you this method... but it'll just end up crashing your program
		//the compiler is not checking for unchecked exceptions... don't need a throws declaration
		
		//throwChecked(); //again, you can run this if there is a "throws MyCheckedException" declaration in main
		//but again it will crash your program.
		
		System.out.println("=====================================(Try/Catch)");
		
		try { //try will TRY a block of code that may or may not throw an exception
			
			System.out.println("try block starting...");
			
			throwChecked();
			
			System.out.println("I won't print - once the Exception is thrown, the rest of the try block is skipped");
			
		} catch (MyUncheckedException e) {
			
			System.out.println("Will I run? No!!!!! I'm only checking for MyUncheckedException");
			
		} catch (MyCheckedException e) {
			
			System.out.println("Hello from the catch block - MyCheckedException was caught!");
			
		} catch (Exception e) {
			
			System.out.println("I could've caught any kind of Exception");
			
		} finally {
			System.out.println("Hello from the finally block - I will always run");
		}
		
		
		System.out.println("The program is still running, thanks to our try/catch");
		
		//It's best practice to write your catch blocks from most specific to least specific
		//Very common to see the final catch block catch just a generic Exception
		//Also, if you put the most generic exception up top, you'll get "unreachable code" errors
		
		
		//trying to catch an ArithmeticException (which we will never cause on purpose but we will here for science)

		
		try {
			
			System.out.println("I'm going to try to divide by zero >:)");
			
			System.out.println("What is your age?");
			int age = scan.nextInt();
			scan.nextLine();
			
			System.out.println("How many years have you been coding?");
			int codingExp = scan.nextInt();
			scan.nextLine();
			
			System.out.println("You have been alive "+(age/codingExp)+" times more than you have been coding");		
			
			//this is unrealistic btw, we'd never do this on purpose		
			
		} catch (ArithmeticException e){
			System.out.println("You haven't been coding long.");
		}
		
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
