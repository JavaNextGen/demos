package com.revature;

//This Thread will extend Thread and override the run() method
public class CoolThread extends Thread {

	//the run() method is the process/behavior you want your Thread to have
	@Override
	public void run() {
		
		for(int i = 0; i < 10; ++i) {
			//this StringBuffer will be populated with the name of the current thread we're in
			//using StringBuffer because it's thread safe :)
			StringBuffer sb = new StringBuffer(Thread.currentThread().getName());
			
			//append a message to the StringBuffer so we can print out a "working" message
			sb.append(" is working...");
			
			System.out.println(sb); //might delete
			
			//This is so that we can see the Thread working...
			try {
				Thread.sleep(500); //Threads will wait 500 milliseconds before running
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Thread is finished!!");
		
	}
	
}
