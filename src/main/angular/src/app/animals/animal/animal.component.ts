 import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
 import {Animal} from "../../Animal";
 import {AnimalServiceService} from "../../animal-service.service";

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent implements OnInit {

  @Input()
  animal: Animal
  @Output()
  onDelete: EventEmitter<Animal> = new EventEmitter<Animal>();

  constructor(private animalService: AnimalServiceService) {
  }

  ngOnInit() {
  }

  delete() {
    this.animalService.delete(this.animal).subscribe(
      data => {
        this.onDelete.emit(this.animal)
      }
    )
  }
}
