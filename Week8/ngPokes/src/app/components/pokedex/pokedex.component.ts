import { HttpStatusCode } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Pokemon } from 'src/app/models/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit {

  //declare an empty message to be changed below
  message:string = "";
  //this object will let us subscribe to observables
  subscription: Subscription = new Subscription();

  //this is the input variable referred to by the two way binding in our HTML
  public input:number = 0;

  public pokemon:any = null;

  //constructor injection so that we can use the getPokemonFromApi function of the service
  constructor(private ps:PokemonService) { }

  //when the component first starts up, change our message variable to the observable from the service.
  ngOnInit(): void {
    this.subscription = this.ps.currentMessage.subscribe(serviceMessage => this.message = serviceMessage);
  }

  //This is the function that gets our Pokemon object from the Pokemon Service
  //the Service has a function that gets a Pokemon as an observable
  //In order to get data from an Observable we need to SUBSCRIBE to it
  getPoke():void{
    this.ps.getPokemonFromApi(this.input).subscribe(

      //get the data out of the observable that we subscribed to, and put it into a Pokemon object
      (data:any) => {
        let response:String = data.status //gets the status code 

        console.log(response);

        //assign the body of the GET request (which has pokemon data) to our Pokemon variable above
        this.pokemon = data.body;
        //we may have to do something with sprites
        console.log(this.pokemon) //will be helpful for debugs

        //increment the counter in the service
        this.ps.counter++;

        //call changeMessage(), which hanges the message on the welcome component
        this.ps.changeMessage("Number of Pokemon Found: " + this.ps.counter);

      },
      () => { //in case of errors, set pokemon to null since we didn't get anything back
        this.pokemon = null;
        console.log("It got away!!")
      }
    )
  }
}
