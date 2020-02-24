import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Animal} from "../../Animal";
import {AnimalServiceService} from "../../animal-service.service";

@Component({
  selector: 'app-creation-animal',
  templateUrl: './creation-animal.component.html',
  styleUrls: ['./creation-animal.component.css']
})
export class CreationAnimalComponent implements OnInit {
  addAnimalForm = new FormGroup({
    name: new FormControl("", Validators.required),
    species: new FormControl("", Validators.required)
  });
  @Output()
  onSave: EventEmitter<Animal> = new EventEmitter<Animal>()

  constructor(private animalService: AnimalServiceService) {
  }

  ngOnInit() {
  }

  save($event: Event) {
    this.animalService.save(this.addAnimalForm.value).subscribe(
      data => {
        this.onSave.emit()
      },
      error => console.log(error)
    )
  }
}
