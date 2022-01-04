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

//Let's assign a variable to our button
let myButton = document.getElementById("b1") //this will get our button (which has an id == b1)

//giving the button functionality
myButton.onclick = domFunc //this will execute the function called domFunc below

//using eventListeners to handle events on my h3 element
document.getElementById("header1").addEventListener("mouseover", hoverFunc)
document.getElementById("header1").addEventListener("mouseleave", releaseFunc)
//so when you mouse over header1, hoverFunc() executes
//then when you leave header1, releaseFunc() executes

//we could have also assigned the results of this DOM selection to variables... 
//but I wanted to show eventListener syntax

function domFunc() {
    console.log("domFunc is running");
    document.getElementById("b1").textContent = "Thanks for the click!"; 
    document.getElementById("p3").textContent = "Now I have content!"
    //textContent is my favorite way to change the text content of an element
}

function hoverFunc(){
    console.log("hoverFunc is running!");
    document.getElementById("header1").textContent = "DON'T TOUCH MEEEE"
}

function releaseFunc() {
    console.log("releaseFunc is running!")
    document.getElementById("header1").textContent = "why did you leave me :("
}
