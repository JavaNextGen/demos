package com.revature;

public class Launcher {

	
	//in this method, we declare an int argument, as well as a String varargs. 
	//So we'll get one int value, and a variable amounts of Strings
	public static void varargsMethod(int a, String... varargsString) {
		
		System.out.println("Number of the day: " + a); //print out the int argument
		
		System.out.println("Phrase of the day:");
		
		//enhanced for loop...
		//for every String (that I'll call string as the variable name) inside the varargsString Array,
		//I'm going to print that String value
		//so basically, we're going to iterate through the Array that was created by the varargs argument
		for(String string : varargsString) {
			System.out.println(string);
		}	
		
		for(String string : varargsString) {
			System.out.println(string);
		}	
		
	}
	
	public static void main(String[] args) {
		
		//call the varargs method, giving it an int value, and some amount of String values
		varargsMethod(56, "Hi", "Hello", "Good Morning", "It's a good day");
		
		System.out.println("============================================================");
		
		varargsMethod(68, "Goodbye", "it was almost nice to see you", "come again soon");	

		
	}
}
