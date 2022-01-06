console.log("===================(Class Declaration)")
//defining a class with a class declaration (using the class keyword)
//we'll also add a constructor

class Dog{
    //constructor to initialize values
    constructor(name, color, isPuppy){
        this.name = name;
        this.color = color;
        this.isPuppy = true;
    }

    bark() {
        alert(this.name + " goes BORK BORK BORK BORK BORK from a class declaration");
    }
}

console.log(Dog); //print the contents of the Dog Class to the console

//instantiate a Dog object using the constructor
let dog1 = new Dog("Coco", "double dapple", true)

//make dog1 bark with the bark function
dog1.bark();

console.log(dog1); //just to see the contents of dog1

console.log("===================(Class Expression)")

//Defining a Class with a Class expression (assigning an object to a variable)
//notice how dog and Dog can coexist!! JS treats them as two different things

let dog = {

    name:"Chip",
    color:"Black",
    isPuppy:true,

    whine(){
            alert(this.name + " is whining cuz he ain't dining from a Class Expression");
    }
}

console.log(dog); //print the contents of the dog variable (assigned to a class expression)

dog.whine(); //invoke the whine function

console.log("================(Inheritance)")

//using inhertance in JS with a variable called newDog that inherits from dog

//new object using another class expression
//use the __proto__ property to declare dog as a parent class

let rocky = {
    breed:"German Shepard",
    __proto__:dog //this makes the dog variable the parent of rocky
}

rocky.name = "Rocky"; //we can change the values of rocky's fields

console.log(rocky.name); //just to make sure that change actually occurred

rocky.whine(); //we can also access the inherited whine function of the dog class!

console.log(rocky); //print him out just to show