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
		
		String concat = s1 + s2;
		System.out.println(concat);
		System.out.println(s1);
		
		
		
		//tbd... StringBuilder, Scanner

	}

}
