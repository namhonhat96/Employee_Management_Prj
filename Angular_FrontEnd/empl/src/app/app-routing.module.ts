import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HousingsComponent } from './housing/housing.component';

const routes: Routes = [
  { path: 'housing', component: HousingsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
////