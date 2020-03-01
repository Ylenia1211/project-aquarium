import { Component, OnInit } from '@angular/core';
import {Animal} from "../Animal";
import {Pool} from "../Pool";
import {AnimalServiceService} from "../animal-service.service";
import {PoolService} from "./pool.service";

@Component({
  selector: 'app-pools',
  templateUrl: './pools.component.html',
  styleUrls: ['./pools.component.css']
})
export class PoolsComponent implements OnInit {
  pools: Array<Pool>

  constructor(private poolService: PoolService) {
  }
  ngOnInit() {
    this.refresh(null)
  }

  refresh($event: Pool) {
    this.poolService.getAll().subscribe(
      data => this.pools = data,
      error => console.log(error))
  }
}
