package com.revature.models;

//This is an Interface, which contains fields and abstract methods
//It's common practice to give Interfaces verb-like names that describe what they do
public interface Walkable {

	//Interface fields are public, static, final by default. You don't have to explicitly state it!
	String unitOfMeasurement = "miles";
	
	//Abstract method - no method body! AKA no implementation public abstract by default
	void move(int distance); //note the semicolon, not curly braces... it's an ABSTRACT method
	
	//default concrete method... which we usually won't use in Interfaces
	default void trip() {
		System.out.println("Oh no you fell!");
	}
	
}
