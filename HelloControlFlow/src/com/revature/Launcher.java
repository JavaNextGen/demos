package com.revature;

import java.lang.Math; //we don't need to do this - the java.lang package is IMPLICITY IMPORTED
//but if it wasn't, this is how we would import the Math class to use it methods

public class Launcher {

	public static void main(String[] args) {
		
		//Math is a Class in the java.lang package - it has methods that let us do basic math stuff, such as random number
		int randomNum = (int)(Math.random() * 100);
		//what are we doing here? we're rounding the decimal places out by casting to an int
		//Math.random() usually returns a double, but casting to int will eliminate the decimal places.
		//Note - casting to int will round DOWN, so the greatest number we can get here is 99. 
		
		
		System.out.println("Today's random number is: " + randomNum);
		
		System.out.println("===================================(if/else-if/else)");
		
		if(randomNum > 75) {
			System.out.println("randomNum is greater than 75");
		} else if (randomNum > 50) {
			System.out.println("randomNum is less than 75, and greater than 50");
		} else {
			System.out.println("randomNum is small");
		}
		
		
		System.out.println("================================(while/do-while loops)");
		
		int smallNum = 2;
		
		while (smallNum < 500) {
			smallNum += 100;
			//we haven't seen += yet: It's basically shorthand for smallNum = smallNum + 100;
			//you can use this syntax with any arithmetic operator. E.g. smallNum *= 2;
			System.out.println("smallNum has increased to: " + smallNum);
		}
		
		System.out.println("While loop has completed! Enjoy your new number");
		
		//now we'll use a do-while loop, which runs a block of code once BEFORE evaluating the boolean
		do {
			smallNum -= 100;
			System.out.println("smallNum has decreased to: " + smallNum);
		} while(smallNum < 1000);
		
		System.out.println("Do While Loop has completed! Enjoy your new number");
		
		
		
		
	}
	
}
