import { EmploymentSectionComponent } from './personal-info/employement-section/employment-section.component';
import { DocumentSectionComponent } from './personal-info/document-section/document-section.component';
import { EmergencyContactComponent } from './personal-info/emergency-contact/emergency-contact.component';
import { ContactInfoSectionComponent } from './personal-info/contact-info-section/contact-info-section.component';
import { AddressSectionComponent } from './personal-info/address-section/address-section.component';
import { NameSectionComponent } from './personal-info/name-section/name-section.component';
import { HomePageCenterComponent } from './home-page-center/home-page-center.component';

import { ReportComponent } from './housing/report/report.component';
import { HouseDetailComponent } from './housing/house-detail/house-detail.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { VisaComponent } from './visa/visa.component';
import { PersonalInfoComponent } from './personal-info/personal-info.component';
import { HousingComponent } from './housing/housing.component';

/*import { WelcomePageModule } from './welcome-page/welcome-page.module';
import { VisaModule } from './visa/visa.module';
import { HousingModule } from './housing/housing.module';
import { PersonalInfoModule } from './personal-info/personal-info.module';*/
import { HomePageRoutingModule } from './home-page-routing.module';


import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,

        HomePageRoutingModule,
        

    ],
    declarations: [
        HomePageCenterComponent,

        WelcomePageComponent,

        VisaComponent,

        HousingComponent,
        HouseDetailComponent,
        ReportComponent,
        
        PersonalInfoComponent,
        
        NameSectionComponent,
        AddressSectionComponent,
        ContactInfoSectionComponent,
        EmploymentSectionComponent,
        EmergencyContactComponent,
        DocumentSectionComponent
    ]
})

export class HomePageModule{}