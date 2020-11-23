import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AddContactService } from "../service/add-contact.service";
import { FormBuilder, FormGroup } from "@angular/forms";

@Component({
  selector: "app-register-contact",
  templateUrl: "./register-contact.component.html",
  styleUrls: ["./register-contact.component.css"],
})
export class RegisterContactComponent implements OnInit {
  relationship: string | any;
  isReference: string | any;
  isEmergency: string | any;

  constructor(
    private router: Router,
    private addContactservice: AddContactService,
    public fb: FormBuilder
  ) {}

  registerContact() {
    this.addContactservice
      .registerContactTable(
        this.relationship,
        this.isReference,
        this.isEmergency
      )
      .subscribe(
        (data) => {
          this.router.navigate(["register-employee"]);
        },
        (error) => {}
      );
  }
  ngOnInit() {}
}
