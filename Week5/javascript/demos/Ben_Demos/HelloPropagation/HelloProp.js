//remember - the addEventListener takes three parameters... 
//the event to listen for, the code to execute, and useCapture which determines how events propagate
document.getElementById("inner").addEventListener("click", 
(event) => {console.log("INNER - capturing")}, true);

document.getElementById("middle").addEventListener("click", 
(event) => {console.log("MIDDLE - capturing")}, true);

document.getElementById("outer").addEventListener("click", 
(event) => {console.log("OUTER - capturing")}, true);

//running these three event listeners will print only OUTER - Capturing is you click the outer div
//BUT it'll print all three, starting with the outermost element if you click the inner div
//With capturing, the outermost element CAPTURES the innermost elements when an event occurs

//now let's see bubbling work--------------------------------------

document.getElementById("inner").addEventListener("click", 
(event) => {console.log("INNER - bubbling")}, false);

document.getElementById("middle").addEventListener("click", 
(event) => {console.log("MIDDLE - bubbling")}, false);

document.getElementById("outer").addEventListener("click", 
(event) => {console.log("OUTER - bubbling")}, false);

//with bubbilng, clicking the outermost element will just print OUTER - Bubbling
//BUT it'll print all three, starting with the INNERMOST element if you click the inner div

//THE BIG DIFFERENCE between bubbling and capturing
//can be observed when we click the innermost element in this demo