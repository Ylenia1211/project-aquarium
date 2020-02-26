import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {EmployeeService} from "../../employee.service";
import {Employee} from "../../Employee";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-creation-employee',
  templateUrl: './creation-employee.component.html',
  styleUrls: ['./creation-employee.component.css']
})
export class CreationEmployeeComponent implements OnInit {

  addEmployeeForm = new FormGroup({
    name: new FormControl("", Validators.required),
    designation: new FormControl("", Validators.required)
  });
  @Output()
  onSave: EventEmitter<Employee> = new EventEmitter<Employee>()

  constructor(private employeeService: EmployeeService,  private router: Router) {
  }

  ngOnInit() {
  }

  save($event: Event) {
    this.employeeService.save(this.addEmployeeForm.value).subscribe(
      data => {
        this.onSave.emit()
        alert("Employee Aquarium created successfully!");
        this.router.navigate(['viewEmployee']);

      },
      error => console.log(error)
    )
  }

}
