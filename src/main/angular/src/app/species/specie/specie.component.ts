import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AuthenticationService} from "../../authentication.service";
import {Specie} from "../Specie";
import {SpecieService} from "../specie.service";

@Component({
  selector: 'app-specie',
  templateUrl: './specie.component.html',
  styleUrls: ['./specie.component.css']
})
export class SpecieComponent implements OnInit {
  @Input()
  specie: Specie;
  @Output()
  onDelete: EventEmitter<Specie> = new EventEmitter<Specie>();

  constructor(private specieService: SpecieService, public loginService:AuthenticationService) {
  }

  ngOnInit() {
  }

  delete() {
    this.specieService.delete(this.specie).subscribe(
      data => {
        this.onDelete.emit(this.specie);
        alert("Specie deleted successfully!");
      }
    )
  }

}
