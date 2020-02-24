import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimalComponent } from './animals/animal/animal.component';
import { CreationAnimalComponent } from './animals/creation-animal/creation-animal.component';
import {ReactiveFormsModule} from "@angular/forms";
import { AnimalsComponent } from './animals/animals.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    AnimalComponent,
    CreationAnimalComponent,
    AnimalsComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
