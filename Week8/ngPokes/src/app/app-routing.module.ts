import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PokedexComponent } from './components/pokedex/pokedex.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

const routes: Routes = [

  {
    path: "",
    component: WelcomeComponent
  },

  {
    path: "pokedex",
    component: PokedexComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
