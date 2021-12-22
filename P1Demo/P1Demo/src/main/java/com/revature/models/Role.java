package com.revature.models;

public class Role {

    private int role_id;
    private String role_title;
    private int role_salary;
    
    
    //boilerplate code below-----------------------------------
    
    //no args
    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }

    //all args
    public Role(int role_id, String role_title, int role_salary) {
        super();
        this.role_id = role_id;
        this.role_title = role_title;
        this.role_salary = role_salary;
    }

    //we could add an all args constructor minus the role_id, if we wanted some "add role" functionality
    //but since we won't do that, it's not neccessary... feel free to practice on your own to do this
    
    @Override
    public String toString() {
        return "Role [role_id=" + role_id + ", role_title=" + role_title + ", role_salary=" + role_salary + "]";
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_title() {
        return role_title;
    }

    public void setRole_title(String role_title) {
        this.role_title = role_title;
    }

    public int getRole_salary() {
        return role_salary;
    }

    public void setRole_salary(int role_salary) {
        this.role_salary = role_salary;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + role_id;
        result = prime * result + role_salary;
        result = prime * result + ((role_title == null) ? 0 : role_title.hashCode());
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
        Role other = (Role) obj;
        if (role_id != other.role_id)
            return false;
        if (role_salary != other.role_salary)
            return false;
        if (role_title == null) {
            if (other.role_title != null)
                return false;
        } else if (!role_title.equals(other.role_title))
            return false;
        return true;
    }
}
