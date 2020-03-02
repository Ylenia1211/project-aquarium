import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Employee} from "./Employee";
import {Observable} from "rxjs";
import {Animal} from "./Animal";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get("/employee")
  }

  /*save(employee: Employee, idPool: number): Observable<any> {
    return this.http.post("/employee/pool/"+idPool, employee)
  }*/
  save(employee: Employee): Observable<any> {
    return this.http.post("/employee", employee)
  }
  delete(employee: Employee): Observable<any> {
    return this.http.delete("/employee/" + employee.idEmployee)
  }

}
