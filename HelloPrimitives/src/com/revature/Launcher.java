package com.revature;

public class Launcher {
	
	//to autogenerate a main method: type "main" and ctrl + space 
	public static void main(String[] args) {
		
		//syso + ctrl + space to autogenerate a print statement
		System.out.println("===========================================(Integer Primtives)");
		
		//These first 4 primitives we'll see are Integers - whole signed numbers, no decimals
		
		byte b = 1; //bytes are one byte in size, from -128 to 127
		System.out.println(b); //print out the variable b to the console
		
		short s = 300; //shorts are 2 bytes in size, from -32768 to 32767
		System.out.println(s);
		
		int i = 200000; //4 bytes in size, from -2,147,836,648 to 2,147,836,647
		System.out.println(i);
		
		long l = 9000000000000000000L; //8 bytes in size, from very low to very high
		System.out.println(l);
		
		System.out.println("===========================================(Chars)");
		
		//chars are 2 bytes in size and will always be written in single quotes
		char c = 'a'; 
		char c2 = 67; //67 is unicode for the value 'C'
		char c3 = '$';
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		
		System.out.println("==========================(Floating-point primitives)");
		
		//these next two primitives are floating point numbers - they can have decimals
		
		double d = 2.2; //8 bytes in size
		System.out.println(d);
		double d2 = 2;
		System.out.println(d2); //this will automatically give you a decimal place
		
		float f = 42.07f; //4 bytes in size
		System.out.println(f);
		
		System.out.println("============================(Booleans)");
		
		//the last primitive type is boolean, this is the ONLY way to denote true/false in Java
		
		boolean bool = true;
		boolean bool2 = false;
		
		System.out.println(bool);
		System.out.println(bool2);
		
		
		System.out.println("=============================(Arithmetic Operators)");
		
		//creating some variables to demonstrate the arithemetic operators
		int sum = 5 + 5;
		int difference = 20 - 10;
		int product = 5 * 2;
		int quotient = 100 / 10;
		int remainer = 30 % 20;
		
		//you can do mathematical operations within print statements using number OR variables
		System.out.println(5 + 5);
		System.out.println(sum + difference);
		System.out.println(sum * difference / quotient * remainer);
		
		//parenthesis will work like usual (PEMDAS)
		System.out.println((sum + difference) * 500);
		
		System.out.println("===================================(Increment/Decrement)");
		
		//we use ++ to increase a number by 1, and -- to decrease a number by 1
		//very useful in loops, which we'll see Friday
		
		int funnyNumber = 24;
		System.out.println("funnyNumber is equal to: " + funnyNumber); 
		//this is how you concatenate (attach) values to each other in a print statement
		
		funnyNumber++; //this will increase the value of our variable by 1.
		System.out.println("but you know what's funnier than 24?: " + funnyNumber);
		
		funnyNumber--; //this will decrease the value of our variable by 1.
		System.out.println("25 is too funny... decrease it please: " + funnyNumber);
		
		funnyNumber++; //this will still increment funnyNumber, but we won't see it if we don't print it out
		
		System.out.println("================================(Pre/Post Increment)");
		
		//a prefix increment will return the value of a variable AFTER incrementing
		//a suffix increment will return the value of a variable BEFORE incrementing
		
		int incrementTest = 20;
		
		System.out.println("incrementTest using prefix increment: " + ++incrementTest);
		
		incrementTest = 20; //resetting incrementTest to 20
		
		System.out.println("incrementTest using suffix increment: " + incrementTest++);
		//incrementTest DOES still increment, but it does that after it's called in the print statement
		
		System.out.println("proof that suffix incrementing still increments:" + incrementTest);
		
		
		//experimenting with variable assignments and prefix/suffix increments-----------
		
		//suffix will assign the value first, and then increment
		int x = incrementTest++;
		System.out.println(x);
		
		//prefix will increment and then assign the value
		int j = ++incrementTest;
		System.out.println(j);
		
	}
	

}
