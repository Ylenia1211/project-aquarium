import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Specie} from "../species/Specie";
import {Pool} from "../Pool";
import {Employee} from "../Employee";

@Injectable({
  providedIn: 'root'
})
export class PoolService {

  constructor(private http: HttpClient) {
  }
  getAll(): Observable<any> {
    return this.http.get("/pool")
  }



  save(pool: Pool, id: number): Observable<any> {
    return this.http.post("/pool/employee/"+id, pool)
  }


  delete(pool: Pool): Observable<any> {
    return this.http.delete("/pool/" + pool.idPool)
  }
}
