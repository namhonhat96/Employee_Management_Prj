import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HousingUserComponent } from './housing-user/housing-user.component';
import { HousingComponent } from './housing/housing.component';
import { HousingDetailComponent } from './housing-detail/housing-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HousingUserComponent,
    HousingComponent,
    HousingDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
