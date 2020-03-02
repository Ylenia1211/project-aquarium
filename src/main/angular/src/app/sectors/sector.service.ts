import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sector} from "./Sector";

@Injectable({
  providedIn: 'root'
})
export class SectorService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get("/sector")
  }

  save(sector: Sector): Observable<any> {
    return this.http.post("/sector", sector)
  }

  delete(sector: Sector): Observable<any> {
    return this.http.delete("/sector/" + sector.id)
  }
}
