import { HomePageCenterComponent } from './home-page-center/home-page-center.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { VisaComponent } from './visa/visa.component';
import { HousingComponent } from './housing/housing.component';
import { PersonalInfoComponent } from './personal-info/personal-info.component';

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const homePageRoutes: Routes = [
    {
        path: 'home-page',
        component: HomePageCenterComponent,
        children: [
            {
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
            }
        ]
        //loadChildren: () => import('./welcome-page/welcome-page.module').then(m => m.WelcomePageModule)
    }
]

@NgModule({
    imports: [RouterModule.forChild(homePageRoutes)],
    exports: [RouterModule],
  })
  export class HomePageRoutingModule {}