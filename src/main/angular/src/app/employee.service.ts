import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Employee} from "./Employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) {
  }

  getEmployees() {
    return this.http.get<Employee[]>('/employees');
  }
  public deleteEmployee(employee: Employee) {
    return this.http.delete<Employee>("/employees" + "/"+ employee.idEmployee);
  }

  public createEmployee(employee) {
    return this.http.post<Employee>("/employees", employee);
  }
}
