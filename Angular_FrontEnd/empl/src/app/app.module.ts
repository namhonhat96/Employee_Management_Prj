import { HomePageModule } from "./home-page/home-page.module";
import { Router } from "@angular/router";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { HeaderComponent } from "./header/header.component";
import { FooterComponent } from "./footer/footer.component";
import { LoginComponent } from "./login/login.component";
import { LogoutComponent } from "./logout/logout.component";
import { AngularMaterialModule } from "./angular-material.module";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { BasicAuthHtppInterceptorService } from "./service/basic-auth-interceptor.service";
import { HomePageComponent } from "./home-page/home-page.component";
import { RegisterUserComponent } from "./register-user/register-user.component";
import { RegisterEmployeeComponent } from "./register-employee/register-employee.component";
import { RegisterPersonComponent } from "./register-person/register-person.component";
import { RegisterVisaComponent } from "./register-visa/register-visa.component";
import { RegisterAddressComponent } from "./register-address/register-address.component";
import { RegisterContactComponent } from "./register-contact/register-contact.component";
import { HrHomePageComponent } from "./hr-home-page/hr-home-page.component";
import { PersonInfoHrComponent } from "./hr-home-page/person-info-hr/person-info-hr.component";
import { VisaHRComponent } from "./hr-home-page/visa/visa.component";
import { HouseHRComponent } from "./hr-home-page/house/house.component";
import { HireComponent } from "./hr-home-page/hire/hire.component";
import { FormAppComponent } from "./hr-home-page/hire/form-app/form-app.component";
import { DocAppComponent } from "./hr-home-page/hire/doc-app/doc-app.component";
import { TestUploadComponent } from "./test-upload/test-upload.component";
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    LogoutComponent,
    HomePageComponent,
    RegisterUserComponent,
    RegisterEmployeeComponent,
    RegisterPersonComponent,
    RegisterVisaComponent,
    RegisterAddressComponent,
    RegisterContactComponent,
    HrHomePageComponent,
    PersonInfoHrComponent,
    VisaHRComponent,
    HouseHRComponent,
    HireComponent,
    FormAppComponent,
    DocAppComponent,
    TestUploadComponent,
  ],
  imports: [
    HomePageModule,
    BrowserModule,
    AngularMaterialModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BasicAuthHtppInterceptorService,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
  constructor(router: Router) {}
}
