package com.revature.models;

//This is an abstract class, note the abstract keyword. It will also implement our interface
//
public abstract class Person {

	//abstract classes can have fields
	public String name;
	public String eyeColor;
	
	//abstract classes can have concrete methods
	public void die() {
		System.out.println("ack I died");
	}
	
	//abstract method - must be declared abstract as well
	public abstract String talk(String words);


	//two constructors (remember, we can't instantiate abstract classes, but the child class will inherit the constructors)
	
	//no args (source -> constructor from superclass)
	public Person() {
		super(); //super() calls the parent class constructor
	}

	//all args (source -> constructor using fields)
	public Person(String name, String eyeColor) {
		super();
		this.name = name;
		this.eyeColor = eyeColor;
	}
	
}
