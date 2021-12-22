--This schema will have two tables that reflect the Employee and Role Classes in our Java

CREATE TABLE roles (
	role_id serial PRIMARY KEY,
	role_title TEXT,
	role_salary int 
);

CREATE TABLE employees (
	employee_id serial PRIMARY KEY,
	f_name TEXT, --first name
	l_name TEXT, --last name 
	role_id int REFERENCES roles (role_id) --foreign key: note the REFERENCES keyword
);

INSERT INTO roles (role_title, role_salary)
VALUES ('Supreme Leader', 100000),
	   ('Fry Cook', 50000),
	   ('Cashier', 40000),
	   ('Marketing', 100000),
	   ('Nepotism', 100000);
	   
SELECT * FROM roles; 

INSERT INTO employees (f_name, l_name, role_id)
VALUES ('Eugene', 'Krabs', 1),
	   ('Spongebob', 'Squarepants', 2),
	   ('Squidward', 'Tentacles', 3),
	   ('Pearl', 'Krabs', 5);

SELECT * FROM employees;

	  