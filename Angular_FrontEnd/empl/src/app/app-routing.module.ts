import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TestListComponent } from './test-list/test-list.component';
const routes: Routes = [
  { path: 'test-list', component: TestListComponent },
  // { path: 'test-add', component: TestUpdateComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
