import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-date',
  templateUrl: './todos-date.component.html',
  styleUrls: ['./todos-date.component.css']
})
export class TodosDateComponent implements OnInit {

  //myDate:Date = new Date(); 
  //This gave us way too much information

  //We found the formatDate() function which returns a String with the date format you like
  myDate:string = formatDate(new Date(), 'yyyy/MM/dd', 'en');

  constructor() { }

  ngOnInit(): void {
  }

}
