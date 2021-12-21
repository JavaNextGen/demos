--The first thing I want to do is create two tables with a relationship
--(using primary key and foreign key constraints)

--This schema will be made to track turtles and their owners

--owners table
CREATE TABLE owners(
	owner_id serial PRIMARY KEY, --The primary key uniquely identifies a table. typically is xyz_id
	--serial is an auto-incrementing data type. We don't need to add a value to it when we insert data
	--whenever we insert a new owener, the owner_id will be generated for us
	name TEXT NOT NULL --since this has a not null constraint, we have to provide values for name
);

--turtles table
CREATE TABLE turtles(
	turtle_id serial PRIMARY KEY,
	name TEXT,
	age int CHECK (age > 0), --no unborn turtles in this turtle nursery! any turtle with age < 0 can't be inserted.
	weight decimal(5, 2), --5 total digits, 2 decimal places. so 3 numbers to the left of the decimal, 2 to the right.
	
	owner_id int REFERENCES owners (owner_id) ON UPDATE cascade --this is a FOREIGN KEY. (note the use of "references")
	--this is saying, this foreign key is bound to the primary key (onwer_id) of the owners table
	--THIS IS HOW WE ESTABLISH RELATIONSHIPS BETWEEN OUR TABLES OF DATA (in a relational database)
);

--You want to create the tables that the other tables depend on FIRST
--Notice how we can't create the turtles table is the owners table doesn't exist (the foreign key depends on it)

--Since the turtles table has a reference to the owners table, there's a relationship
--In this case, one owner can have many turtles. - a "one to many relationship"
--we'll talk about cardinality later this week (one-to-one, one-to-many many-to-many)

DROP TABLE owners;

--why can't we drop the owners table? it's a problem because the turtles table depends on it (with its foreign key)
--we COULD drop the owner's table by using the CASCADE keyword

DROP TABLE owners CASCADE; --this CASCADEs changes to dependent tables. the changes cascade over.
DROP TABLE turtles; 

--you could also just drop the dependent table first (turtles) then drop owners

--DML-------------------------------------------------

--Now, let's use some Data Manipulation Language (DML): Select, Insert, Update, Delete

--INSERT some data into the owners, and turtles into the turtles table

--in INSERT statements, we specify what table and what column we're inserting data into
--and then, we can specify one or many records to insert.
INSERT INTO owners (name) 
VALUES ('Patrick'), ('Payton'), ('Eilese'), ('Felix');

--we can use SELECT to view the data in a table

--I want to return all the owner records that we just inserted
SELECT * FROM owners; --we use * to select every column from the records (as opposed to only selecting certain columns)

--Now I want to insert some turtles 
INSERT INTO turtles (name, age, weight, owner_id)
VALUES ('Franklin', 45, 98.76, 1),
	   ('Leonardo', 67, 13.56, 2),
	   ('Blastoise', 25, 90.32, 3),
	   ('Carol', 56, 125.65, 3);
	   
--select all the turtles
SELECT * FROM turtles;

--we can also select data from specific columns instead of all columns (*)

SELECT name FROM turtles; --return all turtle names

SELECT name, age, weight FROM turtles; --return these specific columns only

--The WHERE clause-------------------------------------------------

--turtles who are named Franklin (=)
SELECT * FROM turtles WHERE name = 'Franklin';

--!= works in the opposite way. this will give me all the turles NOT named Franklin
SELECT * FROM turtles WHERE name != 'Franklin';

--turtles younger than 50 (<)
SELECT * FROM turtles WHERE age < 50;

--turtles with names that start with L (like) (%)
SELECT * FROM turtles WHERE name LIKE 'L%';
--% acts as a wildcard, while like determines the data that should be there

--turtles with names that end in o (like) (%)
SELECT * FROM turtles WHERE name LIKE '%o';

--turtles between 50 and 100 pounds (between)
SELECT * FROM turtles WHERE weight BETWEEN 50 AND 100;
SELECT * FROM turtles WHERE name BETWEEN 'a' AND 'd'; --you can also do it with letters (I've never done this but cool)

--turtles who are named Blastoise or Carol (or) (in)
SELECT * FROM turtles WHERE name = 'Blastoise' OR name = 'Carol'; --(expression) or (expression) or (expression)......
SELECT * FROM turtles WHERE name in ('Blastoise', 'Carol'); --checks if the column is within an array of values

--turtles who are NOT named Blastoise or Carol (not in)
SELECT * FROM turtles WHERE name NOT in ('Blastoise', 'Carol');

--Also important is the ORDER BY clause, which lets us return data in a specific order

SELECT * FROM turtles ORDER BY weight, age; --ascending order by default... if the weight is the same, it orders by age.

SELECT * FROM turtles ORDER BY age DESC; --desc to set it to order by descending order

--------------------------------------------------------------------------------------------------

--We can also UPDATE values in our tables
--Be careful!! You should ALWAYS use a WHERE clause, or else every single row will change

--This will update Franklin's age to 1
UPDATE turtles SET age = 14 WHERE turtle_id = 1;

SELECT * FROM turtles; --just to show that the age was changed

--increment every turtle's age by 1
UPDATE turtles SET age = age + 1;


--We can DELETE rows too. I usually don't do this - when you persist (save) data to a database, it's usually there to stay
--but there are also cases where delete can be useful. Imagine you finally delete your twitter. 
--your account and its info will get deleted off the database

--like with update, you should probably specify a where clause so you don't delete your whole table
DELETE FROM turtles WHERE name = 'Carol';

--rip carol

--foreshadowing... this is an aggregate function that counts how many records get returned
SELECT count(*) FROM turtles WHERE age > 5; 


UPDATE owners SET owner_id = 7 WHERE owner_id = 3;
--this command will not work... due to referential integrity rules!
--you can't update/delete something that has other records referencing it.



