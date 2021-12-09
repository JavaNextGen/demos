package com.revature.models;

//Bugatti extends Car! So what? First of all, this is the primary example of Inheritance (OOP pillar)
//This means that the Bugatti Class inherits all of the fields and methods (members) of the Car class
//BUT, it can also have its own fields and methods unique to the Bugatti Class
//Bugatti is therefore a child class of Car. (Child/Parent relationship) (subclass/superclass relationship)
public class Bugatti extends Car {

	//Bugatti has all the fields of the Car class, as well as this field which is unique to Bugatti
	public int clout; 
	
	//Bugatti has the drive() method of the Car class, as well as this method unique to Bugatti
	public void wakeUp() {
		System.out.println("I woke up in a new Bugatti");
	}
	
	//Method Overriding below------- note the @Override annotation
	
	
	
	//Making a no-args and all-args constructor---------------------
	
	public Bugatti() {
		super(); //This call to super() will call the no-args constructor of the Car class.
		this.clout = 9001;
	}

	public Bugatti(int tires, int doors, String color, int clout) {
		super(tires, doors, color); //This call to super() will call the all-args constructor of the Car class.
		this.clout = clout;
	}
	
}
