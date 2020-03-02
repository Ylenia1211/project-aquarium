import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Employee} from "../../Employee";
import {EmployeeService} from "../../employee.service";
import {AuthenticationService} from "../../authentication.service";
import {Sector} from "../Sector";
import {CreationSectorComponent} from "../creation-sector/creation-sector.component";
import {SectorService} from "../sector.service";

@Component({
  selector: 'app-sector',
  templateUrl: './sector.component.html',
  styleUrls: ['./sector.component.css']
})
export class SectorComponent implements OnInit {

  @Input()
  sector: Sector;
  @Output()
  onDelete: EventEmitter<Sector> = new EventEmitter<Sector>();

  constructor(private sectorService: SectorService, public loginService:AuthenticationService) {
  }

  ngOnInit() {
  }

  delete() {
    //console.log("sector delete: " + this.sector)
    this.sectorService.delete(this.sector).subscribe(
      data => {
        this.onDelete.emit(this.sector)
        alert("Sector deleted successfully!");
      }
    )
  }

}
