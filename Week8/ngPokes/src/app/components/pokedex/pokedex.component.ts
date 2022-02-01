import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit {

  //this is the input variable referred to by the two way binding in our HTML
  public input:number = 0;

  public pokemon:any = null;

  //constructor injection so that we can use the getPokemonFromApi function of the service
  constructor(private ps:PokemonService) { }

  ngOnInit(): void {
  }

  //This is the function that gets our Pokemon object from the Pokemon Service
  //the Service has a function that gets a Pokemon as an observable
  //In order to get data from an Observable we need to SUBSCRIBE to it
  getPoke():void{
    this.ps.getPokemonFromApi(this.input).subscribe(

      //get the data out of the observable that we subscribed to, and put it into a Pokemon object
      (data:any) => {
        //assign it to our Pokemon variable above
        this.pokemon = data;
        //we may have to do something with sprites
        console.log(this.pokemon) //will be helpful for debugs
      },
      () => { //in case of errors, set pokemon to null since we didn't get anything back
        this.pokemon = null;
        console.log("It got away!!")
      }

    )
  }

}