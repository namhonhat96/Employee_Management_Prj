import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AddVisaService } from "../service/add-visa.service";
import { AddApplicationService } from "../service/add-application.service";

@Component({
  selector: "app-register-visa",
  templateUrl: "./register-visa.component.html",
  styleUrls: ["./register-visa.component.css"],
})
export class RegisterVisaComponent implements OnInit {
  visaType: string | any;
  active: string | any;
  createUser: string | any;
  pendinguser: string | any;
  constructor(
    private router: Router,
    private addVisaservice: AddVisaService,
    private addAppService: AddApplicationService
  ) {
    this.createUser = localStorage.getItem("username");
  }

  registerVisa() {
    this.addVisaservice
      .registerVisa(this.visaType, this.active, this.createUser)
      .subscribe(
        (data) => {
          this.addAppService.registerAppTable(1111, "OnBoarding");
          this.router.navigate([""]);
          this.pendinguser = localStorage.getItem("username");
          localStorage.clear();
          localStorage.setItem("pendinguser", this.pendinguser);
        },
        (error) => {}
      );
  }

  ngOnInit() {
    this.createUser = localStorage.getItem("username");
  }
}
