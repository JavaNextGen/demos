--This SQL script will demonstrate Normal Forms 

--Then we'll get into joins and set operations

--I ALSO want to fit a transaction at the end here (TCL)


--A table in 1st Normal Form
--Tables must have a primary key (can be a composite key)
--Columns must be atomic (real_name should probably be two columns... Ben goofed a lil)

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

DROP TABLE IF EXISTS avengers;


--2NF
--Remove Partial Dependencies
--You can eliminate partial dependencies by having a single column primary key (no composite keys!!)

CREATE TABLE avengers (
	hero_id serial PRIMARY KEY, --no more composite key 
	hero_name TEXT,
	hero_power TEXT,
	f_name TEXT,
	l_name TEXT,
	home_base TEXT,
	street_address TEXT,
	city TEXT,
	state char(2)
);

INSERT INTO avengers (hero_name, hero_power, f_name, l_name, home_base, street_address, city, state)
VALUES ('Spiderman', 'Webby boi', 'Peter', 'Parker', 'His Aunt''s House', '20 ingram street', 'Queens', 'NY'),
	   ('Spiderman', 'Webby boi', 'Miles', 'Morales', 'His Aunt''s House', '20 ingram street', 'Queens', 'NY'),
	   ('Black Widow', 'She could kill me', 'Natasha', 'Romanoff', 'Mother Russia', '123 Putin street', 'Russia', 'RS');

SELECT * FROM avengers;

DROP TABLE IF EXISTS avengers;

--3NF
--Remove Transitive Dependencies (by separating them into new tables)
--The only columns depended on should be primary keys

--home data should be its own table

CREATE TABLE homes (
	home_base TEXT PRIMARY KEY, --example of a non-serial id primary key (which typically we want to avoid this)
	street_address TEXT,
	city TEXT,
	state char(2)
);

--insert some home data for avengers to reference
INSERT INTO homes (home_base, street_address, city, state)
VALUES ('Stark Tower', '200 Park avenue', 'Manhattan', 'NY'),
	   ('Sanctum Sanctorum', '177A Bleecker', 'Greenwich', 'NJ'),
	   ('Avengers Tower', '890 5th Avenue', 'New York', 'NY');
	  
CREATE TABLE avengers (
	hero_id serial PRIMARY KEY, --no more composite key 
	hero_name TEXT,
	hero_power TEXT,
	f_name TEXT,
	l_name TEXT,
	home_base_fk TEXT REFERENCES homes(home_base)
);

INSERT INTO avengers (hero_name, hero_power, f_name, l_name, home_base_fk)
VALUES ('Ironman', 'Rich and sick facial hair', 'Tony', 'Stark', 'Stark Tower'),
	   ('Dr. Strange', 'got those light zoopy zoop things that do stuff', 'Benedict', 'Strange', 'Sanctum Sanctorum');

SELECT * FROM avengers;

--cool, this database is now fully 3NF (which is where we want them to be)

----------------------------------------------------------------------------------------(Joins)

--one more INSERT statement to better demonstrate left/right joins
INSERT INTO avengers (hero_name, hero_power, f_name, l_name)
VALUES ('Hancock', 'He tries', 'Will', 'Smith'); --empty home base field!!!

--Remember, joins combine data from two tables. Multi-table queries (select statements)!!

--note the keywords:
--we specify the type of JOIN, and what column we're joining ON

--INNER JOIN
--return all records with matching data (from the PK/FK) in both tables
SELECT * FROM avengers INNER JOIN homes ON home_base = home_base_fk; 
--This won't change any tables, it's just a powerful select statement that delivers a multi-table view (aka resultset)

--FULL OUTER JOIN
--returns everything from both tables, regardless of matches
SELECT * FROM avengers FULL OUTER JOIN homes ON home_base = home_base_fk;


--LEFT OUTER JOIN
--return everything in the left table, and mathcing columns in the right table
SELECT * FROM avengers LEFT OUTER JOIN homes ON home_base = home_base_fk;


--RIGHT OUTER JOIN
--return everything in the right table, and matching columns in the left table
SELECT * FROM avengers RIGHT OUTER JOIN homes ON home_base = home_base_fk;

----------------------------------------------------------------------(Set Operations)







