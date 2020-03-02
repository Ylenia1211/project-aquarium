import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Employee} from "../../Employee";
import {EmployeeService} from "../../employee.service";
import {AuthenticationService} from "../../authentication.service";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  @Input()
  employee: Employee;
  @Output()
  onDelete: EventEmitter<Employee> = new EventEmitter<Employee>();

  constructor(private employeeService: EmployeeService, public loginService:AuthenticationService) {
  }

  ngOnInit() {
  }

  delete() {
    this.employeeService.delete(this.employee).subscribe(
      data => {
        this.onDelete.emit(this.employee)
        alert("Employee deleted successfully!");
      }
    )
  }

}
