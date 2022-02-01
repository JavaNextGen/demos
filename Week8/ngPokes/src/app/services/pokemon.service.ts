import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from '../models/pokemon';

@Injectable({
  providedIn: 'root'
})

//Remember, the Services are what give more functionality to our components
//We inject services into components, thus giving the component the Service's fields and functions
export class PokemonService {

  //we need to inject HttpClient in order to make HTTP requests in this service class
  constructor(private http:HttpClient) { }

  //This function will get Pokemon data from the PokeAPI
  //Note - we use a GET request to GET a pokemon object, and return it as an observable
    //Note Note - we use observables to get data from a server. It's like a more powerful fetch
  getPokemonFromApi(id:number):Observable<Pokemon>{
    return this.http.get("https://pokeapi.co/api/v2/pokemon/" + id + "/") as Observable<Pokemon>
  }

  //This^ function returns an observable. 
  //We now have to inject this service in the pokedex component to use this function

  //hypothetical function that would let us make POST requests------
  sendPokemonToApi(pokemon:Pokemon){
    this.http.post("URL you're sending data to", pokemon)
  }

  //The URLs you'll be calling to are the appropriate Javalin or SpringMVC handlers in your server

}
