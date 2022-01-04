console.log("===========================(Functions)")

//Let's first make a basic named JS function
//Note, because of hoisting we can call the function before we declare it
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




console.log("============================(Scopes)")