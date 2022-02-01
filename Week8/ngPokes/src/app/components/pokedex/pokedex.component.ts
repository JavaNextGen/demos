import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit {

  //this is the input variable referred to by the two way binding in our HTML
  public input:number = 0;

  public pokemon:any = "placeholder";

  getPoke():void{
    console.log("hi");
  }

  constructor() { }

  ngOnInit(): void {
  }

}
