import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-menu-action',
  templateUrl: './menu-action.component.html',
  styleUrls: ['./menu-action.component.css']
})
export class MenuActionComponent implements OnInit {

  constructor(public loginService:AuthenticationService) { }

  ngOnInit(): void {
  }

}
