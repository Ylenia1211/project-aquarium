import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../employee.service";
import {Employee} from "../Employee";

@Component({
  selector: 'app-creation-employee',
  templateUrl: './creation-employee.component.html',
  styleUrls: ['./creation-employee.component.css']
})
export class CreationEmployeeComponent implements OnInit {

  user: Employee = new Employee(0,"","");

  constructor(
    private employeeService: EmployeeService
  ) { }

  ngOnInit() {
  }

  createEmployee(): void {
    this. employeeService.createEmployee(this.user)
      .subscribe( data => {
        alert("Employee Aquarium created successfully!");
      });

  };

}
