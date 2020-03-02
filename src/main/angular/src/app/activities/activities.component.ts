import { Component, OnInit } from '@angular/core';
import {Animal} from "../Animal";
import {AnimalServiceService} from "../animal-service.service";
import {Activity} from "./Activity";
import {ActivityService} from "./activity.service";

@Component({
  selector: 'app-activities',
  templateUrl: './activities.component.html',
  styleUrls: ['./activities.component.css']
})
export class ActivitiesComponent implements OnInit {

  activities: Array<Activity>

  constructor(private activityService: ActivityService) {
  }

  ngOnInit() {
    this.refresh(null)
  }

  refresh($event:  Activity) {
    this.activityService.getAll().subscribe(
      data => this.activities = data,
      error => console.log(error))
  }
}
