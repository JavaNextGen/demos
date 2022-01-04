console.log("===========================(Functions)")

//Let's first make a basic named JS function
//Note, because of hoisting we can call standard functions before we declare it
helloWorld();

function helloWorld() {
    console.log("HELLO WORLD!!");
};

//Here's an anonymous function, it hasn't been named, but it's been assigned to a variable
var anon = function() {
    console.log("I'm an anonymous function!");
}

//using the anonymous function
anon();

//Arrow functions are like lambdas in Java
var arrow = () => {
    console.log("I'm in an arrow function!");
}

//using the arrow function
arrow();

//Callback functions are a function passed as a parameter in another function
function func1(x) {
    console.log("Inside func1");
    console.log("x = " + x);
} 

function func2(y, func){
    console.log("Inside func2");
    func(y); //so "func" is intended to be a function and take y as an argument
}

func2(15, func1); //so we'll call func2, and pass in func1 as the "func" argument. 
//This makes func1 a callback function. func2 is not a callback function in this case!
//We could throw any function in here... like the arrow function or the anonymous function


//Closures are a a nested function that can access the variables and arguments of it's outer function... 
//but can no longer change their default value
let HelloName = function(name) {
    return function () {
        console.log("Hello " + name)
    }
}
//the nested function can access the name argument, but not change it

//assigning the variable nameBen to the HelloName function with the argument "Ben"
let nameBen = HelloName("Ben");

nameBen(); //"Hello Ben"

HelloName = HelloName("Jamie"); //Now, we can never change the name value from Jamie. It's permanent

HelloName(); //"Hello Jamie"

let namePayton = HelloName("Payton"); //this just causes HelloName to run, with an argument it ignores

//namePayton(); //not a function! it's not recognized by the compiler

console.log("============================(Scopes)")

//BEN will put in some scopes stuff, yell at him if he hasn't and it matters to you