//You can think of the models folder in Angular like the models package in Java.
//We fill it with classes that we intend to make objects of. 
export class Pokemon {

    //this constructor will initialize the Pokemon's variable when we create one
    constructor(
        public name:String,
        public types:Object,
        public sprite:Object
    ){}

}
