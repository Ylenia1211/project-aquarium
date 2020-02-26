import { Component, OnInit } from '@angular/core';
import {Employee} from "../Employee";
import {EmployeeService} from "../employee.service";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  employees: Array<Employee>;

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.refresh(null)
  }

  refresh($event: Employee) {
    this.employeeService.getAll().subscribe(
      data => this.employees = data,
      error => console.log(error))
  }
}
