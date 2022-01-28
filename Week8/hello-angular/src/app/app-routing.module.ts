import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnotherComponentComponent } from './components/another-component/another-component.component';

//The more dynamic way to display components is through ROUTING in the Routes array.
//We use routing to move components in and out of the webpage , depending on the URL
//For this basic demo, we'll have to append the URL to this component
//In the future, we'll use our webpage logic to change the URL to move components around
const routes: Routes = [
  //every valid route needs a path, and a component connected to that path.
  {
    path:"another", //path is the URI (endpoint) to reach this component
    component:AnotherComponentComponent //component refers to the class name of the component
    //remember to IMPORT your component or it won't be recognized
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
