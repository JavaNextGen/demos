console.log("==========================(DOM Selection/Manipulation)")

//I want all my divs with classname coolClass (DOM selection)
let divElements = document.getElementsByClassName("coolClass");

console.log(typeof divElements) //object! We have an array of the divs with classname = "coolClass"

//we can access the objects in the divElements array
let firstDiv = divElements[0];
console.log(firstDiv); //the div's contents get printed out

//We can set attributes of elements directly (DOM Manipulation), though it's not best practice
//There is an actual style object that you can set parameters of for every element.
firstDiv.setAttribute("style", "background-color:pink;");


console.log("==========================(Events)")

