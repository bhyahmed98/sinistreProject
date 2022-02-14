import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddsinistreComponent } from './addsinistre/addsinistre.component';
import { AddphotosComponent } from './addphotos/addphotos.component';


const routes:Routes=[
  {
    path:'',
    component:HomeComponent
    
  },
  {
    path:'addimage/:idsinistre',
    component:AddphotosComponent
  },
  {
    path:'addsinistre',
    component:AddsinistreComponent
  },

]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }
export const routingComponent = [HomeComponent,AddphotosComponent,AddsinistreComponent];