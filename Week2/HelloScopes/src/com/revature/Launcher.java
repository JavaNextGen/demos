package com.revature;

public class Launcher {

	//This is a Classed scoped primitive variable, note the "static", which makes it Class scoped (it belongs to the class)
	//We will immediately assign the value 5 as declaration (In other words, we INITIALIZE the variable)
	static int i = 5;
	
	//Another Class scoped variable, this one is not given a value at declaration. In other words, it's UNINITIALIZED
	static int i2; //uninitialized ints will default to 0
	
	//This is a class scoped reference variable
	//For uninitialized reference variables, the default value is null.
	static Launcher launcher;
	//Launcher is the data type (it's an instance of the Launcher Class, it's not the Launcher class itself) 
	
	//This is an instance scoped variable - note no "static" non-access modifier 
	double dub = 5.7; //it's initialized, so all objects of the Launcher class will start with dub being equal to 5.7
	
	//Each instance (object) of the Launcher Class will have its own specific value for the dub variable (it's nonstatic)
	//Each instance (object) of the Launcher Class will share a value for i and i2 (they're static)
	
	//if you change the value of a static variable, that change will happen to all objects of that Class.
	//if you change the value of a non-static variable, that change will only occur for the object you changed it in.
	
	
	public static void main(String[] args) {

		System.out.println("====================================(Class & Instance Scoped Variables)");
		
		System.out.println(i); //this will print 5
		
		System.out.println(i2); //this will print 0, since it's uninitialized
		
		//System.out.println(dub); 
		//a static method cannot access non-static variables
		
		//static variables belong to the class, so they can be accessed by other static members (like this method)
		//instance variables belong to INSTANCES of the class (objects), so they aren't visible to static members
		
		
		//initializing the previously uninitialized primitive variable
		i2 = -98;
		
		//initializing the previously uninitialized reference variable
		launcher = new Launcher();
		
		System.out.println(i2); //this primitive variable has been changed (line 43)
		System.out.println(launcher); //reference variables store the location in memory (memory address)
		
		
		//The (static) launcher variable is an object (an instance) of the Launcher Class
		//so with this object, we can access the instance scoped dub variable!!
		System.out.println(launcher.dub);
		//Calling static objects within non-static variables is a way to access non-static variables in static methods
		
		//we can change the dub variable too, since we initialized a launcher object.
		launcher.dub = 500.97;
		
		System.out.println(launcher.dub); //printing out dub just to show that it changed
		
		System.out.println("================================(Making a new Launcher object)");
		
		Launcher launcher2 = new Launcher();
		//launcher and launcher2 are the saem data type (Launcher) but they are two different objects
		
		launcher2.dub = 1234; //give launcher2 a new value for the dub field
		
		//because dub is instance scoped, we can chande dub of launcher and launcher2 without affecting the other
		System.out.println(launcher.dub);
		System.out.println(launcher2.dub);
		
		System.out.println("=====================================(Method/Block scopes)");
		
		//call the example() method below, give it a value of true
		example(true);
		
	}
	
	
	public static void example(boolean bool) {
		
		double d = 25.50; //this is a method scoped - only visible within the method it's declared in
		
		if(bool) {
			char c = 'c'; //this is a block scoped variable - only visible within its block
			
			System.out.println("block scoped variable: " + c);
			
			System.out.println("method scoped variable: " + d); //this is visible since it's in the same method as the if
			//method-scoped d variable is still visible within the f, since the if is inside the method
		}
		
		//System.out.println(c);
		//c is only visible within its block, thus we can't see it outside the if statement
		
	}
	
	
	
	//non-static method accessing the fields
	public void hi() {
		
		System.out.println(i); //this is fine, static members are visible everywhere
		
		System.out.println(dub); //this is fine, non static method accessing non static field
		
		
	}

}
