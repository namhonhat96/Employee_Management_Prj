import { HomePageCenterComponent } from './home-page-center/home-page-center.component';
import { WorkScheduleComponent } from './personal-info/work-schedule/work-schedule.component';
import { TimeAttendanceComponent } from './personal-info/time-attendance/time-attendance.component';
import { StatusComponent } from './personal-info/status/status.component';
import { RegularPayComponent } from './personal-info/regular-pay/regular-pay.component';
import { PositionComponent } from './personal-info/position/position.component';
import { EmploymentComponent } from './personal-info/employment/employment.component';
import { CustomFieldComponent } from './personal-info/custom-field/custom-field.component';
import { CorporateComponent } from './personal-info/corporate/corporate.component';
import { AdditionalEarningComponent } from './personal-info/additional-earning/additional-earning.component';
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

        HomePageRoutingModule

    ],
    declarations: [
        WelcomePageComponent,
        VisaComponent,
        PersonalInfoComponent,
        HousingComponent,
        HouseDetailComponent,
        ReportComponent,
        AdditionalEarningComponent,
        CorporateComponent,
        CustomFieldComponent,
        EmploymentComponent,
        PositionComponent,
        RegularPayComponent,
        StatusComponent,
        TimeAttendanceComponent,
        WorkScheduleComponent,
        WelcomePageComponent,
        HomePageCenterComponent
    ]
})

export class HomePageModule{}