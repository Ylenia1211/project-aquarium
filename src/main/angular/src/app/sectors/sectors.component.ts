import { Component, OnInit } from '@angular/core';
import {Employee} from "../Employee";
import {EmployeeService} from "../employee.service";
import {SectorService} from "./sector.service";
import {Sector} from "./Sector";

@Component({
  selector: 'app-sectors',
  templateUrl: './sectors.component.html',
  styleUrls: ['./sectors.component.css']
})
export class SectorsComponent implements OnInit {

  sectors: Array<Sector>;

  constructor(private sectorService: SectorService) {
  }

  ngOnInit() {
    this.refresh(null)
  }

  refresh($event: Sector) {
    console.log("getAll sector: "+ this.sectorService.getAll())
    this.sectorService.getAll().subscribe(
      data => this.sectors = data,
      error => console.log(error))
  }

}
