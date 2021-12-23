--This SQL script will demonstrate Normal Forms 

--Then we'll get into joins and set operations

--I ALSO want to fit a transaction at the end here (TCL)


--A table in 1st Normal Form
--Tables must have a primary key (can be a composite key)
--Columns must be atomic

CREATE TABLE avengers (
	hero_name TEXT,
	hero_power TEXT,
	real_name TEXT,
	home_base TEXT,
	street_number TEXT, --usually if you aren't doing math operations on a column, you don't need it to be an int
	city TEXT,
	state char(2), --remember me? This will restrict the values to only 2 characters 
	PRIMARY KEY (hero_name, real_name) --composite key!!!!
);

INSERT INTO avengers (hero_name, hero_power, real_name, home_base, street_number, city, state)
VALUES ('Spiderman', 'Webby boi', 'Peter Parker', 'His Aunt''s House', '20 ingram street', 'Queens', 'NY'),
	   ('Spiderman', 'Webby boi', 'Miles Morales', 'His Aunt''s House', '20 ingram street', 'Queens', 'NY'),
	   --Note how everything in the spidermen records are identical except for the real_name
	   --Just remember, a composite key is a primary key spanning multiple columns
	   ('Thor', 'Static Electricity', 'Thor Odinson', 'Homeless', 'a box', 'San Diego', 'CA');
	  
SELECT * FROM avengers;


--drop table


--2NF







