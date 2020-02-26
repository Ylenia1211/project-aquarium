import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Specie} from "./Specie";

@Injectable({
  providedIn: 'root'
})
export class SpecieService {

  constructor(private http: HttpClient) {
  }
  getAll(): Observable<any> {
    return this.http.get("/species")
  }

  getAllSpecies(): Observable<any> {
    return this.http.get("/animal/species")
  }

  save(species: Specie): Observable<any> {
    return this.http.post("/species", species)
  }

  delete(species: Specie): Observable<any> {
    return this.http.delete("/species/" + species.idSpecies)
  }
}
