package com.revature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("==================================================(Time)");
		
		LocalTime lt = LocalTime.now(); //LocalTime is a Class that gives us... the Local Time
		
		System.out.println(lt);
		
		
		
		LocalDateTime ldt = LocalDateTime.now(); //LocalDateTime is a Class that gives us... the Local Date & Time
		
		System.out.println(ldt);
		
		
		
		ZonedDateTime zdt = ZonedDateTime.now(); //ZonedDateTime is a Class that gives us... the Zoned Date & Time
		
		System.out.println(zdt);
		
		System.out.println("==================================================(Date)");
		
		//The date object is a lot more versatile for formatting the dates 
		
		Date date = new Date(); //new Date object from java.util
		
		System.out.println(date); 
		
		//What if I just want the date, no time?
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //date formatter... formats dates

		String formattedDate = dateFormat.format(date);
		
		System.out.println(formattedDate);
		
		
		//formatting to show the year, month, day, day of the week, timezone, and millisecond
		dateFormat = new SimpleDateFormat("MM-dd-yyyy-E-z-S");
		
		String formattedDate2 = dateFormat.format(date);
		
		System.out.println(formattedDate2);
		
	}
	
}
