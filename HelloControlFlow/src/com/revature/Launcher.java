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
		} while(smallNum < 10);
		
		System.out.println("Do While Loop has completed! Enjoy your new number");
		
		
		System.out.println("===========================================(For Loops)");
		
		//basic for loop
		
		int loopVictim = 0;
	
		//"for as long as this int i, which starts at 0, is less than 10, increment it once per loop
		for(int i = 0; i < 10; i++) { //it's typical practice to call the int "i" for "iterator"
			loopVictim += 2;
			System.out.println("Our loop victim is now: " + loopVictim);
			System.out.println("Our loop variable/iterator is now: " + i);
			//notice "Our loop variable/iterator is now: 10" never prints, since the loops breaks once i is not > 10
		}
		
		//The loop executed 10 times (0-9 times). Once i = 10, the loop completes and doesn't execute its code again.
		
		
		
		//more interesting use of for loops........
		
		//this is an Array, which we'll talk more about next week
		char[] myName = {'B', 'E', ' ', 'N', 'A', 'A', 'A'};
		
		System.out.println(myName);
		
		//I want to use control flow to clean up this Array so that we only get my name (BEN)
		
		for (int i = 0; i < myName.length; i++) {
			
			//clean out the empty space AND the As in the array
			//note: we use OR (||), but XOR (^) would also work here
			if(myName[i] == ' ' || myName[i] == 'A') {
				continue;
				//if the char at position i is equal to an empty space OR an A, skip this iteration of the for loop
			} 
			
			
			//I commented this code out in order to make the if statement cleaner and demonstrate "or" || ....
			
//			//clean out the As in the array
//			if(myName[i] == 'A') {
//				break;
//				//if the char at position i is equal to A, break the for loop completely
//			}
//			
//			//I separated continue and break into two if statements for clarity...
//			//But it would probably be cleaner if we did an if and elseif
			
			//if none of the if statments run, the char at position i will print
			System.out.print(myName[i]);
			
			//left out the "ln" in "println" in order to print this all on one line
			//note the problem here... this makes the next print statement print on the same line as it
			
		}
		
		System.out.println("=================================(Switch Statement)");
		
		//initialize a variable to use as our switch evaluation
		int age = 30;
		
		//depending on the value of the "age" variable, one of the following cases will run
		switch(age) {
		
		//each case is set up to run certain code if age == to the case.
		//we need break statements at the end of case, or else every case under the one that executes will run
		case 20:
			System.out.println("you are 20 years old");
			break;
		case 23: 
			System.out.println("you are 23 years old");
			break;
		case 24:
			System.out.println("you are 24 years old");
			break;
		default:
			System.out.println("your age does not match any of the cases");
			break;
			//the default case will run if none of the cases above match the switch statment evaluation
		}
		
	}
	
	
}
