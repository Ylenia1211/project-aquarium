import { Component, OnInit } from '@angular/core';
import {Employee} from "../Employee";
import {EmployeeService} from "../employee.service";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employees: Array<Employee>;
  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.employeeService.getEmployees().subscribe(
      response => {this.employees=response;}
    );
  }

  deleteEmployee(employee: Employee): void {
    this.employeeService.deleteEmployee(employee)
      .subscribe( data => {
        this.employees = this.employees.filter(u => u !== employee);
      })
  };



}
