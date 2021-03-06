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
		System.out.println(myCar.getTires()); //4
		System.out.println(myCar.getDoors()); //2
		System.out.println(myCar.getColor()); //Red
		//Because we instantiated myCar with no arguments, it has the default values we gave the no-args constructor
		
		//Using the setter() methods of Car to manipulate the fields
		
		myCar.setColor("chartreuse");
		myCar.setDoors(40);
		myCar.setTires(12);
		
		System.out.println(myCar.getColor());
		System.out.println(myCar.getDoors());
		System.out.println(myCar.getTires());
		
		//these fields have now changed, thanks to the use of the setter methods
		
		//Instantiating a new Car object, using the all-args constructor 
		Car myOtherCar = new Car(3, 4, "Blue");
		
		//Let's print some of myOtherCar's fields-----
		System.out.println(myOtherCar.getTires());
		System.out.println(myOtherCar.getDoors());
		System.out.println(myOtherCar.getColor());
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
		//calling wakeUp() will print out the print statment found in the method
		//this is in contract to the drive() method above, which RETURNS a String that we have to print out
		
		//car.wakeUp(); 
		//objects of type Car cannot call the Bugatti-specific wakeUp() method.
		//Bugatti extends Car, so Bugatti has everything Car has, but Car may not have everything Bugatti has.
		
		
		System.out.println("========================================(Casting)");
		
		//using upcasting---------------
		
		//a subclass-type object (Bugatti) gets assigned to a superclass-type variable (Car)
		Car upCar = new Bugatti();
		
		//this is legal and done implicitly by the compiler, because a Bugatti will always be a Car.
		
		//upCar.wakeUp();
		//upCar is of type Car... so the wakeUp() method doesn't exist
		
		System.out.println(upCar.drive(2000));
		//upCar is of type car, BUT the Bugatti-specific version of drive() will be used. Because we upcasted!
		
		//upCar.doors is valid, because doors exists in the Car class
		//upCar.clout would cause an error, because the clout field does not exist in the Car class
		
		//using downcasting----------------------------------------------------
		
		//Bugatti b = (Bugatti) new Car();
		//This will compile, but will throw an exception at runtime - 
		//It's illegal because not all Cars are necessarily Bugattis. Java doesn't know how to make this distinction
		
		//parent type reference variable assigned to a child class object
		Car downCar = new Bugatti();
		((Bugatti)downCar).clout = 7; //without this explicit downcast, we wouldn't be able to access the clout field
		
		//this is really the only reason you'd downcast. If you need to access members that were hidden by an upcast.
		
	}

}
