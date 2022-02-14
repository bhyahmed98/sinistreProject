import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatListModule} from '@angular/material/list';
import { AppComponent } from './app.component';
import { SinistreComponent } from './sinistre/sinistre.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import { AddsinistreComponent } from './addsinistre/addsinistre.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { AddphotosComponent } from './addphotos/addphotos.component';
import { AppRoutingModule,routingComponent } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    SinistreComponent,
    routingComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    HttpClientModule,
    RouterModule,
    RouterModule.forRoot([]),
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    AppRoutingModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
