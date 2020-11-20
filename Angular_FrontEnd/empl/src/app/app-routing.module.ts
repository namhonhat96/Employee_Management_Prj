import { HomePageCenterComponent } from './home-page/home-page-center/home-page-center.component';
import { WelcomePageComponent } from './home-page/welcome-page/welcome-page.component';
import { VisaComponent } from './home-page/visa/visa.component';
import { HousingComponent } from './home-page/housing/housing.component';
import { PersonalInfoComponent } from './home-page/personal-info/personal-info.component';

//import { HousingComponent}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { 
    path: 'home-page', 
    //loadChildren: () =>  import('./home-page/home-page.module').then(m => m.HomePageModule),
    /*redirectTo: '/home-page-center',
    pathMatch: 'full'*/
    component: HomePageCenterComponent,
  },  
  /*{
    path: 'personal-info',
    component: PersonalInfoComponent
    //loadChildren: () => import('./personal-info/personal-info.module').then(m => m.PersonalInfoModule)
},
{
    path: 'visa',
    component: VisaComponent
    //loadChildren: () => import('./visa/visa.module').then(m => m.VisaModule)
},
{
    path: 'housing',
    component: HousingComponent,
    //loadChildren: () => import('./housing/housing.module').then(m => m.HousingModule)
},
{
    path: 'welcome-page',
    component: WelcomePageComponent

}*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
