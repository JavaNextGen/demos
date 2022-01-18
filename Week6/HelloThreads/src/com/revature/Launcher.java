package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		//instantiate two objects of type CoolThread
		CoolThread t1 = new CoolThread();
		CoolThread t2 = new CoolThread();
		
		//setting the priority for some of the threads... which is a value between 1-10
		//the higher the number, the more priority the Thread has over others
		//Priorities ensure that certain threads run first (or last) but they don't guarantee that they'll stay there
		t1.setPriority(1); //this should make t1 start last
		t2.setPriority(10); //this should make t2 start first
		
		
		System.out.println("Before Thread start() methods==================================");
		
		t1.start();
		t2.start();
		
		CoolThread t3 = new CoolThread();
		
		t3.start();
		
		CoolThread t4 = new CoolThread();
		
		t4.start();
		
	}
	
}
