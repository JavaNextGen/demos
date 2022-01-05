//PokeAPI URL - making a variable to hold the URL, which will make for cleaner code
const url = "https://pokeapi.co/api/v2/pokemon/";

//when the user clicks the submit button, execute the getData function
document.getElementById("btn").onclick = getData;

//This function will return our pokemon data, just like how we did in HelloAjax
//BUT I'm going to use the fetch api to return a promise object
//Remember, async tells a function to return a promise object instead of a direct value
async function getData(){

    //put the user input into a variable
    let userInput = document.getElementById("userInput").value;

    //use the fetch() method to send a request to the PokeAPI with the user's input
    let response = await fetch(url + userInput); //remember, this is a PROMISE object
    //remember, await pauses the function until the promise is returned.

    if(response.status === 200){ //if the response came back with a successsful status code 
        let data = await response.json(); //parse the JSON in the response and turn it into a JS object
        renderHTML(data);
    } else {
        document.getElementById("data").innerHTML = "It got away!";
    }
}
//compare the getData() function to the ajaxFunc() in HelloAjax. This is cleaner/more concise

//this function will use the JS object we parsed from the response to populate our webpage with data
function renderHTML(data) {

    let dataSection = document.getElementById("data"); //this is our currently empty section element

    let nameTag = document.createElement("h3"); //create a header for the pokemon's name
    nameTag.innerHTML = data.name; //assign the pokemon's name to the new header

    let pokePic = document.createElement("img");
    pokePic.setAttribute("src", data.sprites.front_default);

    let pokePic2 = document.createElement("img");
    pokePic2.setAttribute("src", data.sprites.front_shiny);

    //actually populate the section element with the data gathered from the response
    dataSection.appendChild(nameTag);
    dataSection.appendChild(pokePic);
    dataSection.appendChild(pokePic2);
}


