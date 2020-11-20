import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AddEmployeeService } from "../service/add-employee.service";
import { AddVisaService } from "../service/add-visa.service";

@Component({
  selector: "app-register-employee",
  templateUrl: "./register-employee.component.html",
  styleUrls: ["./register-employee.component.css"],
})
export class RegisterEmployeeComponent implements OnInit {
  car: string | any;
  visaStartDate: string | any;
  visaEndDate: string | any;
  driverLisence: string | any;
  driver_exp: string | any;
  isResident: boolean | any;
  selectedValue = null;
  selectCitizen: string | any;
  options = [
    { id: 1, name: "Yes" },
    { id: 2, name: "No" },
  ];

  constructor(
    private router: Router,
    private addEmployeeservice: AddEmployeeService,
    private AddVisaService: AddVisaService
  ) {}

  registerEmployee() {
    this.addEmployeeservice
      .registerEmployeeTable(
        this.car,
        this.visaStartDate,
        this.visaEndDate,
        this.driverLisence,
        this.driver_exp
      )
      .subscribe(
        (data) => {
          if (!this.isResident) {
            this.router.navigate(["register-visa"]);
          } else {
            this.AddVisaService.registerVisa(
              this.selectCitizen,
              "false",
              localStorage.getItem("username")
            ).subscribe();

            this.router.navigate(["register-reference"]);
          }
        },
        (error) => {
          this.router.navigate[""];
        }
      );
  }

  ngOnInit() {
    if (this.selectedValue == "Yes") {
      this.isResident = true;
    }
  }
}
