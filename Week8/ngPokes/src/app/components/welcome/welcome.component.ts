import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { PokemonService } from 'src/app/services/pokemon.service';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  noWrapSlides = false;
  showIndicator = true;

  slides = [
    {image: '../../assets/peach.png', text: 'First'},
    {image: '../../assets/luna.png',text: 'Second'},
 ];

  //empty placeholder String to be changed via the pokedex component
  message:string = "";
  //this object will let us subscribe to observables
  subscription: Subscription = new Subscription();

  //null pokemon object that will be changed via the pokedex component
  pokemon:any = null;

  //inject the PokemonService so we can get its data or use its functions
  constructor(private ps:PokemonService) { }

  //when the component first starts up, change our message to the observable from the service
  ngOnInit(): void {
    //we'll replace our default empty string message with whatever currentMessage is in the service
    //serviceMessage is simply the name I gave to currentMessage to make it more clear where it's coming from
    this.subscription = this.ps.currentMessage.subscribe(serviceMessage => this.message = serviceMessage)
    //remember arrow functions, they take in some values and use them in an expression

    //set the previously empty pokemon object to the pokemon in the service
    this.pokemon = this.ps.pokemon
  }
}
