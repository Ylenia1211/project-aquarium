import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Employee} from "../../Employee";
import {EmployeeService} from "../../employee.service";
import {Router} from "@angular/router";
import {Pool} from "../../Pool";
import {PoolService} from "../pool.service";
import {Sector} from "../../sectors/Sector";
import {SectorService} from "../../sectors/sector.service";

@Component({
  selector: 'app-creation-pool',
  templateUrl: './creation-pool.component.html',
  styleUrls: ['./creation-pool.component.css']
})
export class CreationPoolComponent implements OnInit {

  addPoolForm = new FormGroup({
    namePool: new FormControl("", Validators.required),
    state: new FormControl("", Validators.required),
    volume: new FormControl("", Validators.required),
    responsable: new FormControl("", Validators.required),
    poolSector: new FormControl("", Validators.required)
  });
  @Output()
  onSave: EventEmitter<Pool> = new EventEmitter<Pool>();

  responsable_employees: Array<Employee>;
  sectors: Array<Sector>;
  private tmp: number;
  private tmpSec: number;
  constructor(private employeeService: EmployeeService, private sectorService: SectorService, private poolService: PoolService, private router: Router) {
  }

  ngOnInit() {
    this.viewEmployees();
    this.viewSectors();
  }

  save($event: Event) {
    //console.log("idEMployee :" +  this.addPoolForm.value.responsable);
    this.tmp = this.addPoolForm.value.responsable;
    delete this.addPoolForm.value.responsable;
    this.tmpSec = this.addPoolForm.value.poolSector;
    delete this.addPoolForm.value.poolSector;

   // console.log("postIdEMpl:" +  this.addPoolForm.value.responsable);
    //console.log("tmp :" +  this.tmp);
    this.poolService.save(this.addPoolForm.value, this.tmp, this.tmpSec).subscribe(
      data => {
        this.onSave.emit();
        alert("Pool Aquarium created successfully!");
        this.router.navigate(['viewPool']);
      },
      error => console.log(error)
    )
  }

  viewEmployees(){
    this.employeeService.getAll().subscribe(
      data => {
          if(data!=null){
            this.responsable_employees = data;

          }

      },
      error => console.log(error)
    )
  }

  viewSectors(){
    this.sectorService.getAll().subscribe(
      data => {
        if(data!=null){
          this.sectors = data;

        }

      },
      error => console.log(error)
    )
  }
}
