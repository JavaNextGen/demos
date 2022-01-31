import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-date',
  templateUrl: './todos-date.component.html',
  styleUrls: ['./todos-date.component.css']
})
export class TodosDateComponent implements OnInit {

  myDate:Date = new Date();

  constructor() { }

  ngOnInit(): void {
  }

}
