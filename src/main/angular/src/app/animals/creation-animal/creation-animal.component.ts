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
    species: new FormControl("", Validators.required),
      sex: new FormControl("", Validators.required),
    feature:  new FormControl("", Validators.required),
    extinction: new FormControl("", Validators.required),
    arrivalDate:new FormControl("", Validators.required),
    departureDate: new FormControl("", Validators.required),
    lifeExpectancy: new FormControl("", Validators.required),
      dietaryRegime:  new FormControl("", Validators.required),
      threatLevel:  new FormControl("", Validators.required)
    });
  @Output()
  onSave: EventEmitter<Animal> = new EventEmitter<Animal>();


  speciesType:Array<Specie>;
  sexType: Array<String>  = ["FEMALE","MALE", "NONE"];
  levelType: Array<Number>  = [0,1,2,3,4,5,6,7,8,9,10];
  lifeType: Array<Number>  = [5,10,15,20,30];
  foodType: Array<String>  = ["omnivorous",
    "carnivore",
    "herbivore",
    "fishmonger"];

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
