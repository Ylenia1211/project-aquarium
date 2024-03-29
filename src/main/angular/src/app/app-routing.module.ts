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
import {CreationPoolComponent} from "./pools/creation-pool/creation-pool.component";
import {PoolsComponent} from "./pools/pools.component";
import {SectorService} from "./sectors/sector.service";
import {SectorsComponent} from "./sectors/sectors.component";
import {CreationSectorComponent} from "./sectors/creation-sector/creation-sector.component";
import {CreationActivityComponent} from "./activities/creation-activity/creation-activity.component";
import {ActivityComponent} from "./activities/activity/activity.component";
import {ActivitiesComponent} from "./activities/activities.component";


const routes: Routes = [
  { path:'viewEmployee', component: EmployeesComponent},
  { path:'createEmployee', component: CreationEmployeeComponent},
  { path: 'viewAnimal', component: AnimalsComponent },
  { path: 'addAnimal', component: CreationAnimalComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path:'viewSpecies', component: SpeciesComponent},
  { path:'addSpecies', component: CreationSpecieComponent},
  { path:'createPool', component: CreationPoolComponent},
  { path:'viewPool', component: PoolsComponent},
  { path:'viewSector', component:SectorsComponent},
  { path:'createSector', component:CreationSectorComponent},
  { path:'createActivity', component:CreationActivityComponent},
  { path:'viewActivity', component:ActivitiesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
