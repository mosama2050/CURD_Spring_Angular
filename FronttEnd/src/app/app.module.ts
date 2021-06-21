import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {AppRoutingModule} from "./employee/app-routing.module";
import {FormsModule} from "@angular/forms";
import {EmployeeModule} from "./employee/employee.module";
import {Routes} from "@angular/router";


const routes: Routes = [

  { path: 'employees', loadChildren: () => import('./employee/employee.module').then(m => m.EmployeeModule) },];

@NgModule({
  declarations: [
    AppComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
         EmployeeModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
