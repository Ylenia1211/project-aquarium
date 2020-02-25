import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import {CreationAnimalComponent} from "./animals/creation-animal/creation-animal.component";
import {CreationEmployeeComponent} from "./creation-employee/creation-employee.component";


const routes: Routes = [
  { path:'', component: EmployeeComponent},
  { path:'createEmployee', component: CreationEmployeeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
