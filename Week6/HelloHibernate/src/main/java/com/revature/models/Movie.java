package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movies") //This isn't a necessary annotation, but without it, Hibernate would call the table "Movie" in the DB
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int id;
	
	@Column(unique = true, nullable = false) //so now, every Movie must have a unique name, and it must HAVE a name
	private String title;
	
	//I'll leave the @Column annotation out, since I don't care to change any values here
	private String genre;
	
	//One to Many (technically many to one) relationship with Director - one Director can have many movies 
	//We need to make this a foreign key to the Director table
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "director_id") //This is how you establish relationships and foreign keys - 
									  //the name attribute must equal the name of the id of Director in the DB
	//@Column(name = "director_id_fk") //gonna see if this works...
	public Director director;

	
	//What is FetchType and CascadeType??
	
	//FetchType - defines WHEN Hibernate will go to the DB to fetch the object being called for (Director in this case)
	//Two options: EAGER and LAZY
	/*
	 * LAZY: Hibernate will give a proxy object instead of getting the actual data from the DB, 
	 * until your code calls for the object 
	 */
	/*
	 * EAGER: Hibernate returns the dependent object IMMEDIATELY, instead of using a proxy object
	 * This is generally less error prone... why?
	 * Well, if you close a Session, proxy objects aren't available anymore.
	 */
	
	//what's a PROXY OBJECT? Think of it like an "empty" object that gets filled only when it's needed
	//This is good for memory management, think of it as a lightweight placeholder
	//For our needs though, we don't need to save up on memory in such an intense way
	
	
	//CascadeType - defines how the queries will maintain Referential Integrity 
	//So in the case of CascadeType.ALL, all operations will occur when needed (updates and deletes etc. will cascade)
	//We tend to leave it on ALL for the most referential integrity
	
	
	
	//boilerplate code---------------------------
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movie(String title, String genre, Director director) {
		super();
		this.title = title;
		this.genre = genre;
		this.director = director;
	}


	public Movie(int id, String title, String genre, Director director) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.director = director;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public Director getDirector() {
		return director;
	}


	public void setDirector(Director director) {
		this.director = director;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", director=" + director + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Movie other = (Movie) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
	
}
