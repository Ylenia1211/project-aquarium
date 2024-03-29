import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Animal} from "./Animal";
import {Pool} from "./Pool";

@Injectable({
  providedIn: 'root'
})
export class AnimalServiceService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get("/animal")
  }

/*  save(animal: Animal): Observable<any> {
    return this.http.post("/animal", animal)
  }
*/
  delete(animal: Animal): Observable<any> {
    return this.http.delete("/animal/" + animal.id)
  }
  save(animal: Animal, id: number): Observable<any> {
    return this.http.post("/animal/pool/"+id, animal)
  }

}
