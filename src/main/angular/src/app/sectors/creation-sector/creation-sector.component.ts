import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Employee} from "../../Employee";
import {EmployeeService} from "../../employee.service";
import {Router} from "@angular/router";
import {Sector} from "../Sector";
import {SectorService} from "../sector.service";

@Component({
  selector: 'app-creation-sector',
  templateUrl: './creation-sector.component.html',
  styleUrls: ['./creation-sector.component.css']
})
export class CreationSectorComponent implements OnInit {


  addSectorForm = new FormGroup({
    name: new FormControl("", Validators.required),
    localitation: new FormControl("", Validators.required)
  });
  @Output()
  onSave: EventEmitter<Sector> = new EventEmitter<Sector>()

  constructor(private sectorService:SectorService,  private router: Router) {
  }

  ngOnInit() {
  }

  save($event: Event) {
    this.sectorService.save(this.addSectorForm.value).subscribe(
      data => {
        this.onSave.emit()
        alert("Sector Aquarium created successfully!");
        this.router.navigate(['viewSector']);

      },
      error => console.log(error)
    )
  }
}
