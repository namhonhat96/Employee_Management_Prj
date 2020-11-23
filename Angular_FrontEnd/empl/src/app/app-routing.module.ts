import { LoginComponent } from "./login/login.component";
import { LogoutComponent } from "./logout/logout.component";
import { AuthGaurdService } from "./service/auth-gaurd.service";
import { HomePageComponent } from "./home-page/home-page.component";
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HousingsComponent } from './housing/housing.component';

const routes: Routes = [
  { path: "", component: HomePageComponent, canActivate: [AuthGaurdService] },
  { path: "login", component: LoginComponent },
  {
    path: "logout",
    component: LogoutComponent,
    canActivate: [AuthGaurdService],
  },
  { path: 'housing', component: HousingsComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class AppRoutingModule {}

