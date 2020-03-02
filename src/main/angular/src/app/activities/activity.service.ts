import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Animal} from "../Animal";
import {Activity} from "./Activity";

@Injectable({
  providedIn: 'root'
})
export class ActivityService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get("/activity")
  }

  save(activity: Activity): Observable<any> {
    return this.http.post("/activity", activity)
  }

  delete(activity: Activity): Observable<any> {
    return this.http.delete("/activity/" + activity.id)
  }
}
