import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employees/employee/employee.component';
import {CreationEmployeeComponent} from "./employees/creation-employee/creation-employee.component";
import {LoginComponent} from "./login/login.component";
import {LogoutComponent} from "./logout/logout.component";
import {AnimalComponent} from "./animals/animal/animal.component";
import {CreationAnimalComponent} from "./animals/creation-animal/creation-animal.component";
import {AnimalsComponent} from "./animals/animals.component";
import {EmployeesComponent} from "./employees/employees.component";
import {SpeciesComponent} from "./species/species.component";
import {CreationSpecieComponent} from "./species/creation-specie/creation-specie.component";


const routes: Routes = [
  { path:'viewEmployee', component: EmployeesComponent},
  { path:'createEmployee', component: CreationEmployeeComponent},
  { path: 'viewAnimal', component: AnimalsComponent },
  { path: 'addAnimal', component: CreationAnimalComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path:'viewSpecies', component: SpeciesComponent},
  { path:'addSpecies', component: CreationSpecieComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
