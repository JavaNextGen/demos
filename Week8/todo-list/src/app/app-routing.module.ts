import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodosHomeComponent } from './components/todos-home/todos-home.component';

const routes: Routes = [

{
  path: "todoList",
  component: TodosHomeComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
