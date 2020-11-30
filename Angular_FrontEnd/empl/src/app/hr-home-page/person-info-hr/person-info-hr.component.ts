import { Component, OnInit } from "@angular/core";

import { Employee } from "src/app/home-page/housing/employee";
import { EmployeeServiceService } from "src/app/service/employee-service.service";
import { Person } from "src/app/service/person";
import { PersonServiceService } from "src/app/service/person-service.service";
import { Visa } from "src/app/service/visa";
import { VisaServiceService } from "src/app/service/visa-service.service";
import { Observable, combineLatest, of } from "rxjs";
import { map, switchMap } from "rxjs/operators";
import { uniq, flatten } from "lodash";
@Component({
  selector: "app-person-info-hr",
  templateUrl: "./person-info-hr.component.html",
  styleUrls: ["./person-info-hr.component.css"],
})
export class PersonInfoHrComponent implements OnInit {
  employees: Employee[] = [];
  persons: Person[] = [];
  visas: Visa[] = [];

  isName = false;
  isEmplID = false;
  checkName: boolean;
  checkID: boolean;

  constructor(
    private personService: PersonServiceService,
    private employeeService: EmployeeServiceService,
    private visaService: VisaServiceService
  ) {
    this.checkName = false;
    this.checkID = false;
  }

  ngOnInit() {
    if (!this.isName && !this.isEmplID) {
      this.personService.findAllPersons().subscribe((data) => {
        this.persons = data;
      });

      this.employeeService.findAllEmployees().subscribe((data) => {
        this.employees = data;
      });

      this.visaService.findAllVisas().subscribe((data) => {
        this.visas = data;
      });

      //Matching between Employees and Person
    }
  }

  searchName() {
    this.checkName = !this.checkName;
    //search the name from User table
  }
  searchEmplID() {
    this.checkID = this.checkID;
    //Search visa status on Visa Status table matching visaID from EmployeeTable
  }
}
