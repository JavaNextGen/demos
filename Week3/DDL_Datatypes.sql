--Data Definition Language (DDL): create, alter, truncate, drop
--DDL is any command that relates to building the structure of your data (tables, etc.)
--It doesn't deal directly with data!!

--create will CREATE your tables in your database 
CREATE TABLE users(
	username TEXT
);
--we created a (bad) table of users that simply tracks a username

--OH NO! I meant to add an age column to my table. I can use the ALTER command to change or add columns
ALTER TABLE users ADD user_age int;

--we can DROP a table with the drop command
DROP TABLE users; 

--not shown: TRUNCATE, which drops all records in a table

--TRUNCATE TABLE users;

--so DROP deletes the table and all of its data... and TRUNCATE deletes only the data 

--this is an extremely rudimentary table, mostly just to show DDL commands

-------------------------------------------------------------------------------------------------------

--SQL datatypes

--this is a horribly designed table (no primary key, not normalized)
--it's just to list out some datatypes

CREATE TABLE datatypes (
	small_number int2, --2 bytes, for smaller number (think like short in Java)
	normal_number int, --4 bytes, most common int type, same as int4
	big_number int8, --8 bytes, for BIG numbers
	standard_decimal decimal(10, 2), --2 parameters: (total digits, decimal places)
	--so this decimal has 10 total digits, with 2 decimal places. 
	
	"boolean" boolean, --double quotes let you use keywords as column names, etc.
	
	fixed_length_text char(2), --will be 2 characters, not best practice unless you NEED a text field of a certain length  
	variable_length_text varchar(15), --can be from 0-15 characters, better practice than char
	unlimited_length_text TEXT, --unlimited length, best practice if you don't need to limit the amount of characters
	
	"date" date, --YYYY-MM-DD
	"timestamp" timestamp --YYYY-MM-DD HH-MM-SS 
);

--This is NOT all of the datatypes... There are so many
--But most of the time, data will just be numbers, text, and times, and the occasional boolean




