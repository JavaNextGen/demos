package com.revature.models;

//This is a class meant to model a Car - you can think of it like a template/blueprint for all objects that are Cars
//It defines all the fields (variables/attributes) and methods (behvaiors) that I want a Car object to have

public class Car {

	
	//declaring some car fields, we will give them values in constructors below------------
	
	//These fields are private because we're using encapsulation. we can access these fields thanks to getters and setters
	private int tires;
	private int doors;
	private String color; //for now, just know that Strings store text. We'll talk more about them next week
	
	//giving the Car class a method------------
	
	//This method will return a String with the "return" keyword, and take in an int to help create the String. 
	public String drive(int speed) {
		return "You are driving " + speed + " miles per hour"; //Concatenating Strings and the int speed variable
		//note that this isn't System.out.println!!
		//we'll see how return types work when we call this method in our Launcher
	}
	
	//Some constructors below-----------------------------------
	
	//Remember, constructors are special methods that let us instantiate an object.
	//In other words, we provide initial values to the object's variable. (Hence why we say we initialize an object)
	
	//No-args constructor
	//If you create a new Car object without arguments, this no-args constructor will called 
	//Thus, giving our new object these default values.
	public Car() {
		this.tires = 4;
		this.doors = 2;
		this.color = "Red";
	}
	
	//All-args constructor 
	public Car(int tires, int doors, String color) {
		this.tires = tires;
		this.doors = doors;
		this.color = color;
		
	//what is this.xyz?
	//we're saying the tires/doors/color of THIS object we're creating is = the tires/doors/color given in the arguments
		
	}

	//Getters and Setters so that we can access our private fields, and complete our encapsulation
	//Getters let us retrieve the fields
	//Setters let us manipulate the fields
	//You can generate these easily by going to source -> generate getters & setters
	
	public int getTires() {
		return tires;
	}

	public void setTires(int tires) {
		this.tires = tires;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}	
	
	
}
