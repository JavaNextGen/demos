import { HttpClient, HttpClientModule, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Pokemon } from '../models/pokemon';

@Injectable({
  providedIn: 'root'
})

//Remember, the Services are what give more functionality to our components
//We inject services into components, thus giving the component the Service's fields and functions
export class PokemonService {

  //counter variable that we will display on the welcome page (will be incremented from pokedex TS)
  counter:number = 0;

  //This is our initial message. BehaviorSubject contains a String that we can change dynamically
  //public messageSource = new BehaviorSubject("(S)Number of Pokemon Found: " + this.counter);
  public messageSource = new BehaviorSubject("Default String from Service");
  //turn the BehaviorSubject into an observable, so other components can get its value
  currentMessage = this.messageSource.asObservable();

  //we'll call this method from the pokedex component to change the default
  changeMessage(message: string){
    this.messageSource.next(message);
  }

  //we need to inject HttpClient in order to make HTTP requests in this service class
  constructor(private http:HttpClient) { }

  //This function will get Pokemon data from the PokeAPI
  //Note - we use a GET request to GET a pokemon object, and return it as an observable
    //Note Note - we use observables to get data from a server. It's like a more powerful fetch
  getPokemonFromApi(id:number):Observable<HttpResponse<Pokemon>>{
    return this.http.get("https://pokeapi.co/api/v2/pokemon/" + id + "/", {observe: "response"}) as Observable<HttpResponse<Pokemon>>
  }

  //{observe: "response"} lets us get the entire HTTP Response (including stuff like status code)

  //This^ function returns an observable. 
  //We now have to inject this service in the pokedex component to use this function

  //hypothetical function that would let us make POST requests and return the Pokemon back------
  sendPokemonToApi(pokemon:Pokemon):Observable<Pokemon>{
    let p:Observable<Pokemon> = this.http.post("URL you're sending data to", pokemon) as Observable<Pokemon>
    return p;
  }

  //The URLs you'll be calling to are the appropriate Javalin or SpringMVC handlers in your server



}
