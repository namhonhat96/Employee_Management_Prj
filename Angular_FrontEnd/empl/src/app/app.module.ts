import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
<<<<<<< HEAD
import { TestListComponent } from './test-list/test-list.component';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [AppComponent, TestListComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
=======

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
>>>>>>> parent of 31db27d... testing
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
