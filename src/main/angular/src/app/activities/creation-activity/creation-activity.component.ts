import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Activity} from "../Activity";
import {ActivityService} from "../activity.service";
import {EmployeeService} from "../../employee.service";
import {PoolService} from "../../pools/pool.service";
import {Employee} from "../../Employee";
import {Sector} from "../../sectors/Sector";
import {Pool} from "../../Pool";

@Component({
  selector: 'app-creation-activity',
  templateUrl: './creation-activity.component.html',
  styleUrls: ['./creation-activity.component.css']
})
export class CreationActivityComponent implements OnInit {

  addActivityForm = new FormGroup({
    nameActivity: new FormControl("", Validators.required),
    dataCal: new FormControl("", Validators.required),
    start: new FormControl("", Validators.required),
    end:  new FormControl("", Validators.required),
    state: new FormControl("", Validators.required),
    responsableAct: new FormControl("", Validators.required),
    poolActivity: new FormControl("", Validators.required)
  });
  @Output()
  onSave: EventEmitter<Activity> = new EventEmitter<Activity>();

  stateType: Array<String>  = ["PUBLIC", "PRIVATE"];
  responsable_employees: Array<Employee>;
  pools: Array<Pool>;
  private tmp: number;
  private tmpSec: number;

  constructor(private activityService: ActivityService, private employeeService: EmployeeService, private poolService:PoolService,
              private router: Router) {
  }

  ngOnInit() {
    this.viewEmployees();
    this.viewPools();
  }

  save($event: Event) {
    this.tmp = this.addActivityForm.value.responsableAct;
    delete this.addActivityForm.value.responsableAct;
    this.tmpSec = this.addActivityForm.value.poolActivity;
    delete this.addActivityForm.value.poolActivity;
    this.activityService.save(this.addActivityForm.value, this.tmpSec, this.tmp).subscribe(
      data => {
        this.onSave.emit()
        alert("Activity added successfully!");
        this.router.navigate(['viewActivity']);

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
  viewPools(){
    this.poolService.getAll().subscribe(
      data => {
        if(data!=null){
          this.pools = data;

        }

      },
      error => console.log(error)
    )
  }
}
