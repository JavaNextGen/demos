# JavaScript

## Background

-   JS designed to be a very flexible language above all else
-   Designed in 9 days, by Brandon Eich, so there are A LOT OF QUIRKS!
-   Originally designed to make webpages dynamic, but not is used for everything.

## Features

-   **Dynamically Typed**
    -   Do not have to delcare type of variables when creating them

```javascript
// All of these are valid declarations of a variable, but certain ones are use over others (look at scope)

// Rarely use
x = 100;
var x = 100;

// Almost always going to be using
let x = 100;
const x = 100;
```

-   **Loosely Typed**
    -   The datatypes of variables can be coerced implicitly

```javascript
const sum = true + true + true; // JS will convert the trues into 1s and add them
```

-   **Interpretated Language**
    -   JS **DOES NOT** get compiled and then executed
    -   It is read one line at a time and executed immediately after reading that line.
-   **High Level Language**
    -   Automatic memory management
    -   Programmers cannot use points or making low level memory operations

### ECMAScript

-   European Computer Manufactors Association
    -   Empty acronym
    -   When it became popular in web browsers, they were utilized as a computer regulatory associated.
    -   Now all they do is JS.
    -   Organization in charge of JavaScript langugage specifications
-   ECMAScript6
    -   back 2015(roughly)
    -   Added a ton of useful features
        -   Arrow Notation
        -   Async/await
        -   Classes
        -   Enhanced object literals
        -   String interpolation
        -   Promises
        -   For/of For/in
        -   Const/let
        -   Symbol
        -   modules (import syntax)

## Primitive Data Types

-   6 PRimitive datastypes
-   All technically still objects
-   null vs undefined
    -   Null is EXPLICITLY a value meaning nothing that MUST be assigned
    -   Undefined is the default value of anything in js

```javascript
const name = "Charles" // string
let age = 28; // number
const isTrainer = true; // boolean
const nothing = null; // null is explicitly given
const undef; // undefined by default
// symbol, never really gets used in JS
```

### Other Data types

-   BigInt
    -   is used to hold large integers outside the baility of the standard number
-   NaN (not a number)
    -   is still technically a datatype of number
    -   it is returned when a mathematical operation encounters a problem and cannot return a valid number value

## Operators

-   Arthimetic operators
    -   -
    -   -
    -   /
    -   %
    -   -
    -   ++
    -   \--
-   Comparisons
    -   <
    -   >
    -   <= >=
    -   !=
    -   ==
    -   ===
        -   **NOTE THE DIFERRENCE OF == vs ===**
            -   99.99% of the time use ===
            -   === compares type and value
            -   where == just compares value

```javascript
if("5" == 5) //return true, Type Coercion used to evaluate the value
if("5" === 5) // return false, bc string != number
```

-   Logical
    -   &&
    -   ||
-   Assignment
    -   =
    -   +=
    -   -=
    -   \*=
    -   %=
-   Ternary Operators
    -   basically a one line if statement
    -   condition ? value1 : value 2
        -   If the condition is met (true) return value 1
        -   if the condition isn't met (false) return value 2

```javascript
let sum = 0;

sum = 5 + 6;

sum += 5;
sum += 6;

for (let i = 0; i < 10; i++) {
	sum += i;
	console.log(sum);
}

console.log(sum); // return 11
```

## Functions

-   A function is a reuable group of code that can be called anywhere in the program
    -   It is analogous to Java Methods
-   You declare a function using the "function" keyword
    -   a function can take any number of parameters you declare
    -   Functions can return values using the keyword "return"
        -   **NOTE** you do not have to specify a return type
-   Functional expressions are known as named or anonmyous
-   **Anonmyous** function
    -   has no identifier (name). IT can still be held in a variable
-   **Arrow** functions
    -   one time use functions that written in one line
    -   the syntax uses =>
-   **Callback function**
    -   are functions that get passed into another function as a parameter
    -   the original function executes the included function
-   **Higher Order Function**
    -   this is any function that utilizes a callback function
-   **Closures**
    -   this an old way of acheiving encapsulation in JS
    -   It's a nested function that can access the variables and arguments of it's outer function but can no longer change their default value

```javascript
(var1) => {
	console.log(var1);
}; // Technically anonymous, would never see a line like this
const varFunc = (var1) => {
	console.log(var1);
}; // Named function

function varFunc() {
	let greeting = "Hello";
	console.log(greeting);
}

varFunc();

//Functional programming tidbit
someArray.map((a) => {
	console.log(a);
}); // return all elements in an array to the console

someArray.map(varFunc); // print out a bunch of hellos, do not need to invoke function

// Closures

function myFunc() {
	let counter = 0;

	function counterAdd() {
		counter++;
		console.log(counter);
	}

	return counterAdd();
}

// These two variables will have their counter be separate
const charles = myFunc();
charles.counterAdd(); // return 1

const patrick = myFunc();
patrick.counterAdd(); // return 1
patrick.counterAdd(); // return 2
patrick.counterAdd(); // return 3
patrick.counterAdd(); // return 4
```

## Scope

-   Global Scope
    -   Available anywhere in the program
    -   NO keyword
-   Function Scope
    -   available anywhere in the function
    -   var
-   Block Scope
    -   only available within the block
        -   only available within the curly braces
        -   can declare variables multiple times if they are in separate curly braces
    -   let or const
        -   **let**
            -   this variable is the new & preferred declaration for MUTABLE variables
            -   this lets you **REASSIGN** values to that variable
            -   **BE CAREFUL** can reassign to a different data type
        -   **const**
            -   this is constant.
            -   Has the same functionality as let, **BUT** once assigned it cannot be changed.
                -   Think "final" in Java

```javascript
x = 10; // global scope, PLEASE DONT USE THIS

var p = 3; // used for function scope, not used as much anymore

let i = 0;
const b = "Hi";

function sayHello() {
	var greeting = "Hello"; // function scope variable
	console.log(greeting);
}

console.log(greeting); // would result in error bc greeting never declared outside of function scope

if (1 > 2) {
	const value = true;
	function hi() {
		const greeting = "hello";
	}

	console.log(greeting); // will result in error bc greeting is declare in function not block scope
	console.log(value);
} else {
	const value = false;
	return value;
}
```

## Objects

-   Objects are just a collection of key-value pairs
    -   Together a key-value pair is known as a proptery
-   Objects do not need to be created from a class. Classes didn't exist in JS until ECMAScript6.
-   Objects are ALWAYS mutable
    -   always add, edit, remove
-   **Object Literal** is the most common way to create an object.

```javascript
const dog = { name: "Rover", owner: "Charles", color: "red" }; // object lieral

// To access these values, used Dot or Bracket Notation

// Dot notation
dog.name; // is equal to Rover

// Bracket Notation
dog["name"]; // also equals Rover

// Specific enhanced for loop syntax
// for-in loop iterates over

for (const key in dog) {
	console.log(dog[key]); // print every value for every key
}
```

-   **Enhanced Object Literal**
    -   Alternate syntax for objects

```javascript
const dog = {
	name: "Rover",
	bark() {
		console.log("BORK");
	}
};
```

## Arrays

-   Arrays in JS are used to store many values
    -   arrays contain indices
-   CAN STORE ANY DATA TYPE
-   AUTOMATICALLY resize themselves

```javascript
const stuff = [10, true, null, "hello", { fname: "Charles" }];

for (let i = 0; i < stuff.length; i++) {
	console.log(stuff[i]);
}

// Enhanced for loop for arrays
// for-of loop

for (const item of stuff) {
	console.log(item);
}
```

### Array Methods

-   Array has built in methods for functional programming
-   4 major ones that you should know
    -   push(element) - adding another element
    -   pop() - removing the last element in array and return that element
    -   filter(callback function)
        -   filter out any results that don't match the callback function
    -   map(callback function)
        -   apply some function to all elements in the array

## Hoisting

-   Hoisting is a default JS mechanism where variables and function declarations are move to the top of their scope before code execution
    -   **Note** that variable declarations are hoisted **but** not the assignment
    -   all of your varaibles are undefined until that assign happens in the script
-   Variables declared with let and const CANNOT be hoisted.
-   JS uses a two pass system when executing the code
    -   finds variables and functions and makes default values for them.
    -   functions can be made after their called

```javascript
// Completely fine and acceptable JS
var num;
num = 10;

console.log(num); // return 10

console.log(num + num2); // return of NaN, num2 is considered undefined because the declaration was hoisted to the top of the script

var num2 = 7;

// THIS IS WHY LET AND CONST ARE SO IMPORTANT
let num; // this will prevent hoisting, will error
num = 10;

console.log(num); // return 10

console.log(num + num2); // return of NaN, num2 is considered undefined because the declaration was hoisted to the top of the script

const num2 = 7; //prevents hoisting, will error out
```

## Strict mode

-   declaring "use strict" at the top of your JavaScript
    -   means that you will **_NOT_** allow the following:
        -   the use of undefined variables
        -   any keywords as variables or function names
        -   some of the other quirks will be restricted
            -   hoisting still works with use strict be mindful
        -   JS will just error out if any of the above occurs in your code.
-   Implemented in ES6
-   Declared at the global, typically the first line of your script
    -   can also use this within function scope;
-   Don't always use because you can use JS quirks to your advantage.

## NodeJS

-   JS used to ONLY be runable in a webpage
    -   i.e. used for scripts in html
-   NodeJS is a runtime environment for JavaScript
    -   this allows us to run JS code outside of a webpage (or html file).
