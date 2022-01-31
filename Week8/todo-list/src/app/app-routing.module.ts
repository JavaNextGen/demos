import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodosDateComponent } from './components/todos-date/todos-date.component';
import { TodosHomeComponent } from './components/todos-home/todos-home.component';

const routes: Routes = [

{
  path: "todoList",
  component: TodosHomeComponent
},

{
  path: "date",
  component: TodosDateComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
