const url = "https://pokeapi.co/api/v2/pokemon/"; //putting the base URL to PokeAPI in a variable 
//this is for cleaner code. 
//eventually, we'll use this in our requests to make calls to the server by appending endpoints

//get the id of each HTML element to be filled with data (DOM Selection)
let pokename = document.getElementById("pokename");
let poketype = document.getElementById("poketype");
let pokenum = document.getElementById("pokenum");
let pokepic = document.getElementById("pokepic");
//this is just establishing these variables, and we'll fill them with data after the request comes in

//set event listener for clicks of our button
let button = document.getElementById("btn") //DOM selection of the button so we can add a listener
button.addEventListener("click", ajaxFunc); 
//we could have also done button.onclick = ajaxFunc;
//when the button is clicked, it will send a request to the PokeAPI using the ajaxFunc below

//a function that will send the user input to the server (pokeAPI) using AJAX and get a response back 
function ajaxFunc() {

    //gather the user's input, put it into a variable
    let num = document.getElementById("userInput").value; //.value is how we can parse user input

    //initialize an XHR object to send/receive data
    let xhr = new XMLHttpRequest();

    //functionality that executes every time ready state changes 
    //(which will happen when the eventListener fires - when we click the button)
    xhr.onreadystatechange = function(){
        //if (and ONLY if) the response is returned && if status code === 200 (OK)
        if(this.readyState===4 && this.status===200){   
            //take the JSON we get back from the response, and put it in a JS object
            let data = JSON.parse(xhr.responseText);
            renderHTML(data); //see function below - take our data variable and manipulate the DOM
        }
    }

    //open a connection to the server we want to send requests to (PokeAPI)
    //open(method, URL, async)
    xhr.open("GET", url + num, true);

    //send the request to the server
    xhr.send();

    //Why not put .open() and .send() higher up?
    //readystate will be changing throughout this (check notes), but the anonymous function wont run...
    //until xhr.send() successfully gets a response
    //So I put those at the bottom of the function just to demonstrate this
}

//This function will manipulate the DOM based on the user's input & the response from the server
function renderHTML(data){

    //use the data from the server to populate the previously empty text held by the elements
    pokename.innerText = data.name;
    pokenum.innerText = data.id;
    poketype.innerText = data.types[0].type.name;
    if(data.types[1]) { //if there's a second pokemon type... (which will be truthy)
        poketype.append(", " + data.types[1].type.name); //append it!
    }

    //pokepic - need to set the previously empty src attribute
    pokepic.setAttribute("src", data.sprites.front_default);

    //we are getting ALL OF THIS DATA from the JSON gathered from the PokeAPI.

}