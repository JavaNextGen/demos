package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	//what's mappedBy? It's the field in the Movie Class that references the Director class
	//This is how we can achieve ManyToMany functionality without using the ManyToMany annotation, which has more steps
	@OneToMany(mappedBy="director", fetch=FetchType.EAGER)
	private List<Movie> filmography;

	//boilerplate code below.....................
	
	//Classes come with a no args constructor by default
	//BUT if you add a single constructor, that default constructor goes away
	//So we would need to add a no args (just in case)
	public Director() {
		super(); 
		// TODO Auto-generated constructor stub
	}

	//all args with no id
	public Director(String first_name, String last_name, int year_born, List<Movie> filmography) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.year_born = year_born;
		this.filmography = filmography;
	}

	//all args
	public Director(int id, String first_name, String last_name, int year_born, List<Movie> filmography) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.year_born = year_born;
		this.filmography = filmography;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getYear_born() {
		return year_born;
	}

	public void setYear_born(int year_born) {
		this.year_born = year_born;
	}

	public List<Movie> getFilmography() {
		return filmography;
	}

	public void setFilmography(List<Movie> filmography) {
		this.filmography = filmography;
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", year_born="
				+ year_born + ", filmography=" + filmography + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmography == null) ? 0 : filmography.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + year_born;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		if (filmography == null) {
			if (other.filmography != null)
				return false;
		} else if (!filmography.equals(other.filmography))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id != other.id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (year_born != other.year_born)
			return false;
		return true;
	}

	
	
}
