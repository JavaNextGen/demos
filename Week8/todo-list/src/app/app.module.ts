import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodosBannerComponent } from './components/todos-banner/todos-banner.component';
import { TodosHomeComponent } from './components/todos-home/todos-home.component';
import { TodosDateComponent } from './components/todos-date/todos-date.component';

@NgModule({
  declarations: [
    AppComponent,
    TodosBannerComponent,
    TodosHomeComponent,
    TodosDateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
