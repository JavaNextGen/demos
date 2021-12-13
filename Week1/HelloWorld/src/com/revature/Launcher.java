//This is a comment 

//This is a package declaration
//package declarations must be the first line of your file, unless it's a comment 
package com.revature;

//This is a class declaration 
public class Launcher {

	//This is our main method - the entry point of our application. 
	//The opening line of a method is called a method signature. This is a typical main method signature.
	public static void main(String[] args) {
		
		//The code inside a method (inside the curly braces) is called the method body.
		
		//This is a print statement - it PRINTS a message to your console.
		//Whatever you write in the print statement will get printed to the console below
		System.out.println("Hello World!");
		
		System.out.println("I used syso + ctrl + space to autogenerate a print statement!");
		
		System.out.println("My name is Ben");
		
	}
	
	//Here's an example method, check the notes for method anatomy.
	public static int exampleMethod(int a, int b) {
		return a + b;
	}
	
}

