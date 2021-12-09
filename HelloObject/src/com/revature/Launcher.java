package com.revature;

import com.revature.models.Bugatti;
import com.revature.models.Car; //importing the Car class, so that we can make objects of type Car, and access its members
//Even if something is public, you will still have to import it to access it within other packages.
//If Car was in the com.revature package, we wouldn't need to import

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("=========================(Using our Constructors)");
		
		//Instantiating a new Car object, using the no-args constructor (since we gave it no arguments)
		Car myCar = new Car(); 
		//Is this a reference variable or a primitive? Reference variable!! Because it's referencing an object.
			//It's referencing out myCar object, which is of type Car. An object of the Car class.  
		
		//Let's print some of myCar's fields-----
		System.out.println(myCar.tires); //4
		System.out.println(myCar.doors); //2
		System.out.println(myCar.color); //Red
		//Because we instantiated myCar with no arguments, it has the default values we gave the no-args constructor
		
		
		//Instantiating a new Car object, using the all-args constructor 
		Car myOtherCar = new Car(3, 4, "Blue");
		
		//Let's print some of myOtherCar's fields-----
		System.out.println(myOtherCar.tires);
		System.out.println(myOtherCar.doors);
		System.out.println(myOtherCar.color);
		//Because we instantiated myOtherCar with 3 arguments, the all-args constructor is called.
		
		//trying to print the reference variables... we get the path, and a random string of characters
		//this is the memory address of the objects!
		System.out.println(myCar);
		System.out.println(myOtherCar);
		//in the future, our model Classes will have toString() methods, which let us print them out 
		
		System.out.println("========================================(using the methods)");
		
		Car car = new Car(); //Instantiating a new Car object
		Bugatti bugatti = new Bugatti(); //Instantiating a new Bugatti object
		
		System.out.println(car.drive(65)); //Using the drive() method of the Car class
		System.out.println(bugatti.drive(65)); //Using the drive() method of the Bugatti class
		
		//Using the wakeUp() method of the Bugatti class
		bugatti.wakeUp();
		
	}

}
