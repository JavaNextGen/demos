package com.revature.models;

//The concrete class Associate extends the Person abstract class
//Think of it as a more specific implementation of the more generic Person type
//The Person Abstract class implements the Walkable Interface... So Associate inherits Walkable's members as well
public class Associate extends Person {

	//this is a field that only belongs to associate
	public String batch;
	
	//we can access the move() method and the unitOfMeasurement field from allll the way in the Walkable Interface
	@Override
	public void move(int distance) {
		System.out.println("I walked " + distance + " " + unitOfMeasurement + " today");
	}

	//we can access the talk() method from the Person Abstract Class
	@Override
	public String talk(String words) {
		return "Ben is aight and " + words;
	}


	//Note* We don't have to override the trip() method from Walkable, since it's concrete

	//three constructors, so we can actually initialize objects of type Associate
	
	//no args constructor from Person
	public Associate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//all args constructor from person
	public Associate(String name, String eyeColor) {
		super(name, eyeColor);
		// TODO Auto-generated constructor stub
	}

	//all args constructor from associate
	public Associate(String batch) {
		super();
		this.batch = batch;
	}
	
	//constructor that don't necessarily need. but it lets us explicitly define every possible field for an Associate
	//including name and eyeColor from Person
	public Associate(String name, String eyeColor, String batch) {
		super(name, eyeColor);
		this.batch = batch;
	}
	
}
