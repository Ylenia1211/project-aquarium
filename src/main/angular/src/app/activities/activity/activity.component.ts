import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AuthenticationService} from "../../authentication.service";
import {Activity} from "../Activity";
import {ActivityService} from "../activity.service";

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent implements OnInit {
  @Input()
  activity: Activity
  @Output()
  onDelete: EventEmitter<Activity> = new EventEmitter<Activity>();

  constructor(private activityService: ActivityService, public loginService:AuthenticationService) {
  }

  ngOnInit() {
  }

  delete() {
    this.activityService.delete(this.activity).subscribe(
      data => {
        this.onDelete.emit(this.activity)
        alert("Activity deleted successfully!");
      }
    )
  }

}
