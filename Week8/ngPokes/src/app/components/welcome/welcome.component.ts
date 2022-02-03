import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  //empty placeholder string to be changed via the pokedex component
  message:string = "";
  ////this object will let us subscribe to observables
  subscription: Subscription = new Subscription();

  constructor(private ps:PokemonService) { }

  //when the component first starts up, change our message variable to the observable from the service.
  ngOnInit(): void {
    this.subscription = this.ps.currentMessage.subscribe(serviceMessage => this.message = serviceMessage);
    //this.ps.changeMessage("Number of Pokemon Found: " + this.counter);
  }
}
