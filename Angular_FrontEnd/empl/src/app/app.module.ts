import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import{HousingsComponent}from './housing/housing.component';
import {HousingDetailComponent} from './housing-detail/housing-detail.component';
import { HttpClientModule } from '@angular/common/http';
import { HousingUserComponent } from './housing-user/housing-user.component';
import { MessagesComponent } from './messages/messages.component';
@NgModule({
  declarations: [AppComponent,  HousingUserComponent, HousingsComponent, HousingDetailComponent, MessagesComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
