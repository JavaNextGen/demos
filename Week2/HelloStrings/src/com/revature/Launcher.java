package com.revature;

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
		
		
		//tbd... StringBuilder, Scanner

	}

}
