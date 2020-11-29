import { Component, OnInit } from "@angular/core";
import { Visa } from "src/app/service/visa";
import { VisaServiceService } from "src/app/service/visa-service.service";
import { Employee } from "src/app/home-page/housing/employee";
import { EmployeeServiceService } from "src/app/service/employee-service.service";
import { Person } from "src/app/service/person";
import { PersonServiceService } from "src/app/service/person-service.service";
import {
  animate,
  state,
  style,
  transition,
  trigger,
} from "@angular/animations";

import { map, switchMap } from "rxjs/operators";
import { uniq, flatten } from "lodash";

@Component({
  selector: "app-visa",
  templateUrl: "./visa.component.html",
  styleUrls: ["./visa.component.css"],
  animations: [
    trigger("detailExpand", [
      state(
        "collapsed",
        style({ height: "0px", minHeight: "0", display: "none" })
      ),
      state("expanded", style({ height: "*" })),
      transition(
        "expanded <=> collapsed",
        animate("225ms cubic-bezier(0.4, 0.0, 0.2, 1)")
      ),
    ]),
  ],
})
export class VisaHRComponent implements OnInit {
  constructor(
    private personService: PersonServiceService,
    private employeeService: EmployeeServiceService,
    private visaService: VisaServiceService
  ) {}
  dataSource: any;
  expandedElement: VisaElement;
  columnsToDisplay: any;
  employees: Employee[] = [];
  persons: Person[] = [];
  visas: Visa[] = [];
  ELEMENT_DATA1: VisaElement[] = [];

  dayDiff(d1Str: any, d2Str: any) {
    const date1 = new Date(d1Str);
    const date2 = new Date(d2Str);
    const diffInMs = Math.abs(date2.getTime() - date1.getTime());
    return (diffInMs / (10000 * 60 * 60 * 24)).toFixed();
  }

  ngOnInit() {
    this.personService.findAllPersons().subscribe((data) => {
      this.persons = data;
    });

    this.employeeService.findAllEmployees().subscribe((data) => {
      this.employees = data;
    });

    this.visaService.findAllVisas().subscribe((data) => {
      this.visas = data;
    });

    this.dataSource = this.initTable();
    this.columnsToDisplay = [
      "Name",
      "WorkAuthorization",
      "ExpirationDate",
      "DayLeft",
      "Action",
    ];
  }

  //Check the employee table and visa status table
  sendNoti() {}

  initTable() {
    // for (let i = 0; i < 3; i++) {
    //   this.ELEMENT_DATA1[i].Name =
    //     this.persons[i].firstname + this.persons[i].lastname;
    //   this.ELEMENT_DATA1[i].WorkAuthorization = this.visas[i].visaType;
    //   this.ELEMENT_DATA1[i].ExpirationDate = this.employees[i].visaEndDate;
    //   var eventStartTime = new Date(this.employees[i].visaStartDate);
    //   var eventEndTime = new Date(this.employees[i].visaEndDate);
    //   this.ELEMENT_DATA1[i].DayLeft =
    //     eventEndTime.valueOf() - eventStartTime.valueOf();
    // }
    this.ELEMENT_DATA1 = [
      {
        Name: "Jason Cook",
        WorkAuthorization: "F1/OPT",
        ExpirationDate: "02/02/2021",
        DayLeft: this.dayDiff("01/01/2020", "02/02/2024"),
        StartDate: "01/01/2020",
        Action: "Send Notificaiton",
      },
      {
        Name: "Adam Timothy",
        WorkAuthorization: "H1-B",
        ExpirationDate: "05/02/2025",
        DayLeft: this.dayDiff("01/01/2020", "05/02/2025"),
        StartDate: "01/01/2020",
        Action: "Send Notificaiton",
      },
      {
        Name: "Mary Johson",
        WorkAuthorization: "L2",
        ExpirationDate: "10/25/2022",
        DayLeft: this.dayDiff("01/02/2020", "10/25/2022"),
        StartDate: new Date("01/02/2020"),
        Action: "Send Notificaiton",
      },
    ];
    return this.ELEMENT_DATA1;
  }
}

export interface VisaElement {
  Name: any;
  DayLeft: any;
  WorkAuthorization: any;
  ExpirationDate: any;
  StartDate: any;
  Action: any;
}
