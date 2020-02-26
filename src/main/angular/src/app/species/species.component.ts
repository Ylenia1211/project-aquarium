import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Specie} from "./Specie";
import {SpecieService} from "./specie.service";
import {Animal} from "../Animal";

@Component({
  selector: 'app-species',
  templateUrl: './species.component.html',
  styleUrls: ['./species.component.css']
})
export class SpeciesComponent implements OnInit {
  species: Array<Specie>
 // @Output()
 // callSpecies: EventEmitter<Array<Specie>> = new EventEmitter<Array<Specie>>();
  constructor(private specieService: SpecieService) { }

  ngOnInit() {
    this.refresh(null)
  }

  refresh($event: Specie) {
    this.specieService.getAll().subscribe(
      data => this.species = data,
      error => console.log(error))
  }

  //call(){}

}
