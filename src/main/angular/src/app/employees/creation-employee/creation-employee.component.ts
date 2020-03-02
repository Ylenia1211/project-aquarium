import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {EmployeeService} from "../../employee.service";
import {Employee} from "../../Employee";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Pool} from "../../Pool";
import {PoolService} from "../../pools/pool.service";
import {Sector} from "../../sectors/Sector";


@Component({
  selector: 'app-creation-employee',
  templateUrl: './creation-employee.component.html',
  styleUrls: ['./creation-employee.component.css']
})
export class CreationEmployeeComponent implements OnInit {

  addEmployeeForm = new FormGroup({
    name: new FormControl("", Validators.required),
    designation: new FormControl("", Validators.required),
    surname:new FormControl("", Validators.required),
    numSecSocial: new FormControl("", Validators.required),
   // poolResponsable: new FormControl("", Validators.required),
    birthday: new FormControl("", Validators.required)

  });
  @Output()
  onSave: EventEmitter<Employee> = new EventEmitter<Employee>()
  designationType: Array<String>  = ["WORKER","RESPONSABLE"];
  pools: Array<Pool>;
  constructor(private employeeService: EmployeeService, private poolService:PoolService,  private router: Router) {
  }

  ngOnInit() {
    this.viewPool();
  }
  private tmp: number;
  save($event: Event) {//add path
   // this.tmp = this.addEmployeeForm.value.poolResponsable;
  //  delete this.addEmployeeForm.value.poolResponsable;
    this.employeeService.save(this.addEmployeeForm.value).subscribe(
   // this.employeeService.save(this.addEmployeeForm.value, this.tmp).subscribe(
      data => {
        this.onSave.emit()
        alert("Employee Aquarium created successfully!");
        this.router.navigate(['viewEmployee']);

      },
      error => console.log(error)
    )
  }
  viewPool(){
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
