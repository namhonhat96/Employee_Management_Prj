import { Component, OnInit } from "@angular/core";
import { Employee } from "src/app/home-page/housing/employee";
import { EmployeeServiceService } from "src/app/service/employee-service.service";
import { Person } from "src/app/service/person";
import { PersonServiceService } from "src/app/service/person-service.service";
import { Visa } from "src/app/service/visa";
import { VisaServiceService } from "src/app/service/visa-service.service";

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

  constructor(
    private personService: PersonServiceService,
    private employeeService: EmployeeServiceService,
    private visaService: VisaServiceService
  ) {}

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
    }
  }
}
