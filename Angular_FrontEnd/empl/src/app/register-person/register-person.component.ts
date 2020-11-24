import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AddPersonService } from "../service/add-person.service";

@Component({
  selector: "app-register-person",
  templateUrl: "./register-person.component.html",
  styleUrls: ["./register-person.component.css"],
})
export class RegisterPersonComponent implements OnInit {
  id: string | any;
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

  getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
  }

  registerPerson() {
    this.id = this.getRandomInt(1000);
    localStorage.setItem("personID", this.id);
    this.addPersonservice
      .registerPersonTable(
        this.id,
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
          this.router.navigate(["register-address"]);
        },
        (error) => {
          this.router.navigate[""];
        }
      );
  }
  ngOnInit() {
    this.email = localStorage.getItem("email");
  }
}
