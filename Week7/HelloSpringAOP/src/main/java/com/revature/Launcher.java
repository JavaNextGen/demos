package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Avenger;
import com.revature.repositories.AvengerDAO;

public class Launcher {

	public static void main(String[] args) {
		
		//Instantiate an ApplicationContext so we can use our beans (ctrl + shift + o to import all at once)
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Instantiate an AvengerDAO object by getting the bean for it
		//Notice we specify AvengerDAO.class, which is cleaner and better practice than casting
		AvengerDAO aDAO = ac.getBean(AvengerDAO.class);
		//AvengerDAO aDAO2 = (AvengerDAO) ac.getBean("avengerDao"); //This is what it used to be!!!
		
		//Instantiate a new Avenger object using the DAO method to get by ID
		Avenger a = aDAO.getById(4);
		
		System.out.println(a);
		
		//Make a new Avenger object by getting the Bean, and filling it with values
		Avenger a2 = ac.getBean(Avenger.class);
		
		a2.setAveId(6);
		a2.setAveName("Armadillo Boy");
		a2.setFirstName("Dyl");
		a2.setLastName("an");
		a2.setPower("He's got armor; you can... curl up. He does armdillo things. I think they, they dig burrows.");
		a2.setPowerLevel(-5);
		
		System.out.println(a2);
		
		System.out.println("==============================================================(Using fight())");
		
		//using the fight() method, once to return successfuly, and once to throw an exception
		System.out.println(aDAO.fight(a2, "I think he, he dug a burrow?", 1000));
		
		//try/catch to catch our arithmetic exception
		try {
			System.out.println(aDAO.fight(a2, "I think he, he dug a burrow?", 1));
		} catch (ArithmeticException e) {
			System.out.println("EXCEPTION CAUGHT!!!!!");
		}
	}
		
}
