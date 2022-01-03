console.log("<<<<<<Showcasing Var>>>>>>>>>>>");
// Using var keyword is weird

var name = "Charles"; // declared name first

var name = "Patrick"; // var oddly allows re-declaration, declared name second

console.log(name); //returns re-declared name variable

name = 10;
console.log(name);

name = true;
console.log(name);

// showcase some let and const
console.log("<<<<<<Showcasing Let/Const>>>>>>>>>>>");
// Using var keyword is weird

let fname = "Charles"; // declared name first

// let fname = "Patrick"; // let prevents any re-declaration
fname = "Patrick";

console.log(fname); //returns re-declared name variable

fname = 10;
console.log(fname);

fname = true;
console.log(fname);

const lname = "Jester";

// lname = "Orwin"; cannot reassign a const variable

console.log(lname);
// Be mindful of your decisions when using let and const
// const should be something that is "final" and never needs to be reassigned
// let can be a value your wish to reassign (think of numbers and booleans)

console.log();
console.log("<<<<<<Showcasing Let/Const>>>>>>>>>>>");

let var1;
// const var2; // will error due to const not allowing undefined assignment because you cannot reassign
const var2 = 10;

var1 = "there";
// say you didn't want var2 to be a number, you can check the datatype is typeof
console.log("Hello " + var1 + " " + var2);
console.log(typeof var2);

let num1 = 1;
let num2 = 2;

num2 = "2";

console.log(num1 + num2);

console.log(typeof num2);

console.log("<<<<<<Showcasing Type Coercion>>>>>>>>>>>");

const tc1 = "5" * 5; // Javascript is converting the string to a number through Type coercion
console.log(tc1 + " is a " + typeof tc1);

const tc2 = "5" * "5";
console.log(tc2 + " is a " + typeof tc2);

const tc3 = 5 + "5";
console.log(tc3 + " is a " + typeof tc3);

const tc4 = "5" + 5;
console.log(tc4 + " is a " + typeof tc4);

// Order doesn't matter when it comes to JS for typecoercion
// It would matters WHEN the string is concatenated.
// Operator also is a key role in how type coercion will work
// JavaScrip PEMDAS - look it up
console.log();
console.log(1 + 3 + 4 + "5" + 2 + 8 + 9 + (10 + 11));

// due to the multiplication operator before the string, it's converted to a number
console.log(1 + 3 + 4 * "5" + 2 + 8 + 9 + (10 + 11));

console.log((1 + 3 + 4 + "5" + 2 + 8) * 9 + (10 + 11));

console.log("<<<<<<Showcasing Arrays & Objects>>>>>>>>>>>");
console.log();

console.log("Here's Arrays");
console.log();

// unlike java you can have a plethora of data types in an array
const arr = ["Hello", 1, true, null, undefined, { fname: "Charles", age: 28 }];

console.log(arr[3]); // return null
console.log(arr[0]); // return Hello
console.log(arr[5]); // returns the object literal

// How do you return my name and age from the array's object literal

console.log(arr[5].fname); // returning the array's object and using dot notation to get hte value
console.log(arr[5]["age"]); // returning the array's object and using bracket notation to get the value

console.log("Here's Object Literals");
console.log();

const obj = { fname: "Charles", lname: "Jester", age: 28, isTrainer: true, happiness: null }; // In JS object literals are declared via {}

console.log(obj);
console.log(obj.fname + " " + obj.lname);

// Note on objects, we can change values

obj.fname = "Manson";
obj["lname"] = "Brown";

console.log(obj.fname + " " + obj.lname);

// Enhanced Object Literal
const obj1 = {
	fname: "Charles",
	lname: "Jester",
	age: 28,
	isTrainer: true,
	happiness: null,
	yell() {
		// considerd a method
		console.log("HELLO THERE!!!!!!!!");
	},
	say: function () {
		//consider a method
		console.log("General Kenobi");
	}
}; // In JS object literals are declared via {}

obj1.yell();
obj1.say();

console.log("<<<<<<Showcasing Control flow>>>>>>>>>>>");
console.log();

console.log("For LOOPS");
console.log();
// Traditional
for (let i = 0; i <= 10; i++) {
	console.log(i);
}

// Enhanced For Loop - Arrays
const eArr = ["Hello", "There", "General", "Kenobi", 5];

for (const element of eArr) {
	console.log(element + 6);
}

// Enhanced For Loops - Object Literals
const eObj = { fname: "Charles", lname: "Jester", age: 28, isTrainer: true, happiness: null };

for (const key in eObj) {
	console.log(eObj[key]); // Cannot use dot notation for enhanced for loops, must use bracket
}

console.log("IF STATEMENTS");
console.log();

let x = -2;
let y = -2;
if (x < 1) {
	console.log(x);
	x++;
}
console.log(x);

while (y < 1) {
	console.log(y);
	y++;
}

// Comparin Strings

const fname1 = "Charles";
const fname2 = "Charles";
const fname3 = "Adam";
const newName = obj;

console.log(newName);

console.log(fname1.replace("r", "d")); // showcasing primitives are also objects

if (fname1 === fname2) {
	console.log("Names match");
	console.log(fname1.replace("r", "d"));
}

if (fname1 === fname3) {
	console.log("Names match");
} else {
	console.log("Names don't match");
}

const number = 1;
const number2 = "1";

// This will print bc JavaScript coercises the 1 into a number
// DONT USE THIS
if (number == number2) {
	console.log("Huzzah");
}

// This won't print due to types not matching
// ALWAYS USE THIS
if (number === number2) {
	console.log("Huzzah Again");
}
