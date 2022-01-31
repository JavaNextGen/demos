import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

  //toggles whether the todo list cards are visible
  hiddenToggle:boolean = true;

  //toggles whether the name div is visible
  nameDivToggle:boolean = false;

  //stores the user inputted name from the greeterDiv
  name:String ="";

  //made 4 todo list objects that we will render onto our webpage
  todo1 = {
    id:1,
    content:"",
    status:"Incomplete"
  }

  todo2 = {
    id:2,
    content:"",
    status:"Incomplete"
  }

  todo3 = {
    id:3,
    content:"",
    status:"Incomplete"
  }

  todo4 = {
    id:4,
    content:"",
    status:"Incomplete"
  }

  //an Array filled with the above todo1-4 objects
  //We'll be calling this from out HTML with String Interpolation
  todosArray = [this.todo1, this.todo2, this.todo3, this.todo4];

  showTodoList() {
    this.hiddenToggle = !this.hiddenToggle; //setting the boolean to the opposite of current value
  }

  submitName(){
    this.nameDivToggle = true;
  }

  completeTask(id:number){
    this.todosArray[id - 1].status = "Complete"
    //-1 because of zero indexing. Otherwise completing task 1 will complete task 2. no good.
  }

  constructor() { }

  ngOnInit(): void {
  }

}
