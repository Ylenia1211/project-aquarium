import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Animal} from "../../Animal";
import {AnimalServiceService} from "../../animal-service.service";
import {AuthenticationService} from "../../authentication.service";
import {Pool} from "../../Pool";
import {PoolService} from "../pool.service";

@Component({
  selector: 'app-pool',
  templateUrl: './pool.component.html',
  styleUrls: ['./pool.component.css']
})
export class PoolComponent implements OnInit {

  @Input()
  pool: Pool
  @Output()
  onDelete: EventEmitter<Pool> = new EventEmitter<Pool>();

  constructor(private poolService: PoolService, public loginService:AuthenticationService) {
  }

  ngOnInit() {
  }

  delete() {
    this.poolService.delete(this.pool).subscribe(
      data => {
        this.onDelete.emit(this.pool)
        alert("Pool deleted successfully!");
      }
    )
  }
}



