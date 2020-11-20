import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AddPersonService } from "../service/add-person.service";

@Component({
  selector: "app-register-person",
  templateUrl: "./register-person.component.html",
  styleUrls: ["./register-person.component.css"],
})
export class RegisterPersonComponent implements OnInit {
  firstname: string | any;
  lastname: string | any;
  middlename: string | any;
  email: string | any;
  cellphone: string | any;
  alternatephone: string | any;
  gender: string | any;
  SSN: number | any;
  DOB: string | any;
  selectedValue = null;
  gender_options = [
    { id: 1, name: "Male" },
    { id: 2, name: "Female" },
    { id: 3, name: "I don't want to answer" },
  ];

  constructor(
    private router: Router,
    private addPersonservice: AddPersonService
  ) {}

  registerPerson() {
    this.addPersonservice
      .registerPersonTable(
        this.firstname,
        this.lastname,
        this.middlename,
        this.email,
        this.cellphone,
        this.alternatephone,
        this.gender,
        this.SSN,
        this.DOB
      )
      .subscribe(
        (data) => {
          this.router.navigate(["register-employee"]);
        },
        (error) => {
          this.router.navigate[""];
        }
      );
  }
  ngOnInit() {}
}
