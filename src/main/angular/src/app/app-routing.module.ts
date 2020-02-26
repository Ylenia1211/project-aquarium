import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import {CreationEmployeeComponent} from "./creation-employee/creation-employee.component";
import {LoginComponent} from "./login/login.component";
import {LogoutComponent} from "./logout/logout.component";


const routes: Routes = [
  { path:'', component: EmployeeComponent},
  { path:'createEmployee', component: CreationEmployeeComponent},
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
