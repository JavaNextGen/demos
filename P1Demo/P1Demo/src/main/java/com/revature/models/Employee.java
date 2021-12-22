package com.revature.models;

//This Class represents the employees table in our database
public class Employee {

	//fields for the employee class - must match those in your database
	private int employee_id;
	private String f_name;
	private String l_name;
	private int role_id;
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Employee(int employee_id, String f_name, String l_name,int role_id) {
		super();
		this.employee_id = employee_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.role_id = role_id;
	}

	//all args MINUS the employee_id primary key... WHY?
	//we will eventually want the capability to add employees... and the employee_id auto increments!!!
	public Employee(String f_name, String l_name, int role_id) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.role_id = role_id;
	}

	//so our Employee objects can be printed out - returns a String describing the object
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", f_name=" + f_name + ", l_name=" + l_name + ", role_id=" + role_id + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	
	//hashcode and equals are necessary if we want to compare (test the equality of) our objects 
	//"Equals/hashcode/toString from the object class initially refer to default memory values
	//but you customize a class to describe and compare itself based off its implementation" - Peter 2021
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employee_id;
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		result = prime * result + role_id;
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
		Employee other = (Employee) obj;
		if (employee_id != other.employee_id)
			return false;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (role_id != other.role_id)
			return false;
		return true;
	}
}
