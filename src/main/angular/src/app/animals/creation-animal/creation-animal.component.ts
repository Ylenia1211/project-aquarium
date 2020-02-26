import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Animal} from "../../Animal";
import {AnimalServiceService} from "../../animal-service.service";
import {Router} from "@angular/router";
import {Specie} from "../../species/Specie";
import {SpecieService} from "../../species/specie.service";

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
  onSave: EventEmitter<Animal> = new EventEmitter<Animal>();


  speciesType:Array<Specie>


  constructor(private animalService: AnimalServiceService,
              private specieService: SpecieService,
              private router: Router) {
  }

  ngOnInit() {
    this.callSpecies(null)
  }

  callSpecies($event: Specie) {
    this.specieService.getAllSpecies().subscribe(
      data => this.speciesType = data,
      error => console.log(error))
  }

  save($event: Event) {
    this.animalService.save(this.addAnimalForm.value).subscribe(
      data => {
        this.onSave.emit()
        alert("Fish added successfully!");
        this.router.navigate(['viewAnimal']);

      },
      error => console.log(error)
    )
  }
}
