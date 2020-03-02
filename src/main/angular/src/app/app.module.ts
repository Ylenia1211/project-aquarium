import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimalComponent } from './animals/animal/animal.component';
import { CreationAnimalComponent } from './animals/creation-animal/creation-animal.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AnimalsComponent } from './animals/animals.component';
import {HttpClientModule} from "@angular/common/http";
import { EmployeeComponent } from './employees/employee/employee.component';
import { CreationEmployeeComponent } from './employees/creation-employee/creation-employee.component';
import { MenuActionComponent } from './menu-action/menu-action.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { EmployeesComponent } from './employees/employees.component';
import { SpeciesComponent } from './species/species.component';
import { CreationSpecieComponent } from './species/creation-specie/creation-specie.component';
import { SpecieComponent } from './species/specie/specie.component';
import { PoolsComponent } from './pools/pools.component';
import { PoolComponent } from './pools/pool/pool.component';
import { CreationPoolComponent } from './pools/creation-pool/creation-pool.component';
import { SectorsComponent } from './sectors/sectors.component';
import { CreationSectorComponent } from './sectors/creation-sector/creation-sector.component';
import { SectorComponent } from './sectors/sector/sector.component';
import { ActivitiesComponent } from './activities/activities.component';
import { CreationActivityComponent } from './activities/creation-activity/creation-activity.component';
import { ActivityComponent } from './activities/activity/activity.component';

@NgModule({
  declarations: [
    AppComponent,
    AnimalComponent,
    CreationAnimalComponent,
    AnimalsComponent,
    EmployeeComponent,
    CreationEmployeeComponent,
    MenuActionComponent,
    LoginComponent,
    LogoutComponent,
    EmployeesComponent,
    SpeciesComponent,
    CreationSpecieComponent,
    SpecieComponent,
    PoolsComponent,
    PoolComponent,
    CreationPoolComponent,
    SectorsComponent,
    CreationSectorComponent,
    SectorComponent,
    ActivitiesComponent,
    CreationActivityComponent,
    ActivityComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
