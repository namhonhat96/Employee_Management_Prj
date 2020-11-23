import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AddAddressService } from "../service/add-address.service";

@Component({
  selector: "app-register-address",
  templateUrl: "./register-address.component.html",
  styleUrls: ["./register-address.component.css"],
})
export class RegisterAddressComponent implements OnInit {
  addressLine1: string;
  addressLine2: string;
  city: string;
  zipcode: number;
  stateName: string;
  stateAbbr: string;
  personID: number;

  map = new Map([
    ["Alaska", "AK"],
    ["Alabama", "AL"],
    ["Arkansas", "AR"],
    ["Arizona", "AZ"],
    ["California", "CA"],
    ["Colorado", "CO"],
    ["Connecticut", "CT"],
    ["Delaware", "DE"],
    ["Florida", "FL"],
    ["Georgia", "GA"],
    ["Hawaii", "HI"],
    ["Iowa", "IA"],
    ["Idaho", "ID"],
    ["Illinois", "IL"],
    ["Indiana", "IN"],
    ["Kansas", "KS"],
    ["Louisiana", "LA"],
    ["Massachusetts", "MA"],
    ["Maryland", "MD"],
    ["Maine", "ME"],
    ["Michigan", "MI"],
    ["Minnesota", "MN"],
    ["Missouri", "MO"],
    ["Mississippi", "MS"],
    ["North Carolina", "NC"],
    ["North Dakota", "ND"],
    ["Nebraska", "NE"],
    ["New Hampshire", "NH"],
    ["New Jersey", "NJ"],
    ["New Mexico", "NM"],
    ["Nevada", "NV"],
    ["New York", "NY"],
    ["Ohio", "OH"],
    ["Oklahoma", "OK"],
    ["Pennsylvania", "PA"],
    ["Rhode Island", "RI"],
    ["South Carolina", "SC"],
    ["South Dakota", "SD"],
    ["Tennessee", "TN"],
    ["Texas", "TX"],
    ["Utah", "UT"],
    ["Virginia", "VA"],
    ["Vermont", "VT"],
    ["Washington", "WA"],
    ["Wisconsin", "WI"],
    ["West Virginia", "WV"],
    ["Wyoming", "WY"],
  ]);

  constructor(
    private router: Router,
    private addAddressservice: AddAddressService
  ) {}

  registerAddress() {
    this.stateAbbr = this.map.get(this.stateName);
    this.addAddressservice
      .registerAddressTable(
        this.addressLine1,
        this.addressLine2,
        this.city,
        this.zipcode,
        this.stateName,
        this.stateAbbr,
        this.personID
      )
      .subscribe(
        (data) => {
          this.router.navigate(["register-contact"]);
        },
        (error) => {}
      );
  }
  ngOnInit() {}
}
