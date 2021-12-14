package com.revature;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {

		System.out.println("====================================(Testing String Equality)");
		
		String s1 = "Hi Java";
		String s2 = "Hi Java"; //since s2 is exactly the same as s1, they will refer to the same object in memory
		String s3 = "hi java"; //this String literal has it's own object in the string pool
		String s4 = new String("Hi Java");
		String s5 = new String("Hi Java"); //s4 and s5 will be two different objects in memory, because used "new"
		
		System.out.println(s1 == s2); //true. == compares memory address. s1 and s2 point to the same string pool object 
		System.out.println(s1 == s3); //false. s1 and s3 are not identical String literals. So they're different objects
		System.out.println(s1 == s4); //false. s4 isn't even in the String pool, since we used the new keyword.
		
		
		//note* these print statements are printing out the boolean value returned by the == comparison operator
	
		System.out.println(s1.equals(s4)); //true, .equals compares VALUES not memory address... 
		//which is why we use it with objects! The values are identical, and that's what we're really trying to compare.
		
		//See why we use .equals() with Strings and == with primitives?
		//We usually want to compare the VALUE of the variable, not the memory location.
		//(Primitives aren't objects, so they aren't stored heap... so == will only the values of primitives)
		
		System.out.println("====================================(Using some String methods)");
		
		
		//Remember, Strings aren't primitives. We assign String objects to reference variables
		//The Strings we're working with are objects/instantiations of the String Class, so we can use its methods
		
		//a pangram to use Strings methods
		String pangram = "Sphinx of Black Quartz, Judge my Vow";
		
		//hopefully these method names are self explanatory
		System.out.println(pangram.toLowerCase());
		System.out.println(pangram.toUpperCase());
		
		//.length() returns the length of the String, in int form
		System.out.println(pangram.length());
		
		//.charAt() returns the character at a given index 
		System.out.println(pangram.charAt(0)); //first character
		System.out.println(pangram.charAt(pangram.length() - 1));
		
		//.charAt() in a for loop
		for(int i = 0; i < pangram.length(); i++) {
			System.out.println(pangram.charAt(i));
		}
		
		//print statement shortcut "syso" + ctrl + space

		//.substring() returns a String that's found within the given String
		System.out.println(pangram.substring(4, 25)); //this will print characters 4-25 of our pangram String
		
		//one more method - .split() will create an Array via specified delimiters
		String[] words = pangram.split(" "); //this Array will hold every word in the pangram
		
		System.out.println(words); //This will simply print a memory address
		
		//we'll use an enhanced for loop to print out the Array's concepts
		for(String word : words) { //"for every String (denoted by the "word" variable) in the words Array, do this"
			System.out.println(word);
		}
		
		//enhanced for loops are a super convenient way to iterate through things like Arrays
		
		//some String theory lol--------
		
		//Note that using the above methods WON'T actually change the original String pangram
		//we've been using methods to print manipulations of the original String, but they aren't stored as new objects
		//See StringBuilder below for mutable String-like behavior
		
		//you COULD always assign a new String variable to the manipulations
		
		String newString = s1 + s2.length() + s3.toUpperCase() + pangram.charAt(16);
		System.out.println(newString);
		
		
		System.out.println("=============================================(StringBuilder)");
		
		//instantiate a new StringBuilder object based on our pangram String
		StringBuilder sb = new StringBuilder(pangram);
		
		//perform some mutations using StringBuilder methods
		sb.reverse(); //reverse the characters
		sb.append("BENJAMIN"); //append my name to the end of the StringBuilder
		sb.insert(12, "PATRICK"); //insert Patrick's name at index 12
		sb.delete(20, 27); //delete the chars found in indeces 20-27
		sb.replace(0, 8, "Hello from the replace method :)"); //replace the chars in indeces 0-8
		
		System.out.println(sb); //the original pangram is completely unrecognizable 
		
		String newerString = sb.toString(); //StringBuilders have a toString() method, which will convert it back into a string 
		//why would you do this? some methods will call specifically for Strings...
		//if I have a String that I need to change, I would make a StringBuilder to make those changes
		//and then use toString() to convert it back into a String.
		
		System.out.println("============================================(Scanner)");

		//create a Scanner Object
		Scanner scan = new Scanner(System.in); //System.in represents the console
		
		System.out.println("What's your name?"); //ask the user a question
		
		String name = scan.nextLine(); //the nextLine() method gathers a user input STRING and moves to the next line
		
		System.out.println(name + " huh?... Lovely name bro"); //now we can use the variable holding the user input
		
		
		System.out.println("How old are you?");
		
		int age = scan.nextInt(); //nextInt() will grab the int, but doesn't make a new line...
		scan.nextLine(); //we need to explicitly call nextLine() in order to actually move to the next line
		
		System.out.println("What?!?!?! " + age + "?? What's your secret?");
		
		String secret = scan.nextLine();
		
		System.out.println("OK starting tomorrow I'll " + secret);
		
		
	}

}
