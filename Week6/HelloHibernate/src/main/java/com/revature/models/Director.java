package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //@Entity makes a Class a DB table
@Table(name = "directors") //@Table lets us change some table values
public class Director {

	@Id //This will make the field a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our PK serial
	@Column(name = "director_id") //usually I'll just call a field what I want it to be called instead of doing this...
	private int id;
	
	//I could give these all fields @Column annotations, but Hibernate will handle them on its own 
	//The only time I would NEED @Column is if I'm changing attributes like constraints
	@Column(unique = true, nullable = false)
	private String first_name;
	
	//@Column
	private String last_name;
	
	//@Column
	private int year_born;
	
	
	
	//boilerplate code below.....................
	
	
	//I'll throw it in tomorrow
	
	
}
