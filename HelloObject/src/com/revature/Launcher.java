package com.revature;

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
		
		
		System.out.println("=========================(using the methods)");
		
	}

}
