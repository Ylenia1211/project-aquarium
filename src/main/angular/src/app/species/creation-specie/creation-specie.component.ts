import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Specie} from "../Specie";
import {SpecieService} from "../specie.service";

@Component({
  selector: 'app-creation-specie',
  templateUrl: './creation-specie.component.html',
  styleUrls: ['./creation-specie.component.css']
})
export class CreationSpecieComponent implements OnInit {

  addSpecieForm = new FormGroup({
    nameSpecies: new FormControl("", Validators.required),
    description: new FormControl("", Validators.required)
  });
  @Output()
  onSave: EventEmitter<Specie> = new EventEmitter<Specie>();

  constructor(private specieService: SpecieService,  private router: Router) {
  }

  ngOnInit() {
  }

  save($event: Event) {
    this.specieService.save(this.addSpecieForm.value).subscribe(
      data => {
        this.onSave.emit()
        alert("Species added successfully!");
        this.router.navigate(['viewSpecies']);

      },
      error => console.log(error)
    )
  }

}
