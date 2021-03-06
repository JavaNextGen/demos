package com.revature.models;

public class Pokemon {

	//fields for the Pokemon Class
	private String name;
	private String type;
	
	//one method
	public void fight() {
		System.out.println(this.name + " attacked!");
	}

	
	//Below is boilerplate code-------
	//boilerplate code is code that you'll typically find in a class
	//to that end, Java makes it convenient to autogenerate from the source tab
	
	
	//no args constructor (source -> generate constructor from superclass)
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor (source -> generate constructor using fields)
	public Pokemon(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	//getters and setters so that we can access our private fields. this is ENCAPSULATION
	//and also abstraction? since we call these methods to get and set things without having to know the code
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	//the toString() method lets you do String-like stuff with your objects, like print them out
	//otherwise, you'd just get the memory address printed out... which makes no sense to us humans
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	
}
