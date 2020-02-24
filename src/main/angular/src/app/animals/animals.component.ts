import { Component, OnInit } from '@angular/core';
import {Animal} from "../Animal";
import {AnimalServiceService} from "../animal-service.service";

@Component({
  selector: 'app-animals',
  templateUrl: './animals.component.html',
  styleUrls: ['./animals.component.css']
})
export class AnimalsComponent implements OnInit {

  animals: Array<Animal>

  constructor(private animalService: AnimalServiceService) {
  }

  ngOnInit() {
    this.refresh(null)
  }

  refresh($event: Animal) {
    this.animalService.getAll().subscribe(
      data => this.animals = data,
      error => console.log(error))
  }

}
