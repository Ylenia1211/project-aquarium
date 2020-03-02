import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Activity} from "../Activity";
import {ActivityService} from "../activity.service";

@Component({
  selector: 'app-creation-activity',
  templateUrl: './creation-activity.component.html',
  styleUrls: ['./creation-activity.component.css']
})
export class CreationActivityComponent implements OnInit {

  addActivityForm = new FormGroup({
    nameActivity: new FormControl("", Validators.required),
    dataCal: new FormControl("", Validators.required),
    start: new FormControl("", Validators.required),
    end:  new FormControl("", Validators.required),
    state: new FormControl("", Validators.required)
  });
  @Output()
  onSave: EventEmitter<Activity> = new EventEmitter<Activity>();

  stateType: Array<String>  = ["PUBLIC", "PRIVATE"];


  constructor(private activityService: ActivityService,
              private router: Router) {
  }

  ngOnInit() {
  }

  save($event: Event) {
    this.activityService.save(this.addActivityForm.value).subscribe(
      data => {
        this.onSave.emit()
        alert("Activity added successfully!");
        this.router.navigate(['viewActivity']);

      },
      error => console.log(error)
    )
  }

}
