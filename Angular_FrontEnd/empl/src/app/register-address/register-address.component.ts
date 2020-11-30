import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AddAddressService } from "../service/add-address.service";
import pdfMake from "pdfmake/build/pdfmake";
import pdfFonts from "pdfmake/build/vfs_fonts";
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import jspdf from "jspdf";
import html2canvas from "html2canvas";
import {
  HttpClient,
  HttpParams,
  HttpRequest,
  HttpEvent,
  HttpEventType,
  HttpResponse,
} from "@angular/common/http";
import { Observable } from "rxjs";
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
  personID: string;

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
    let username = localStorage.getItem("username");
    var data = document.getElementById("contentToConvert");
    html2canvas(data).then((canvas) => {
      // Few necessary setting options
      var imgWidth = 100;
      var pageHeight = 150;
      var imgHeight = (canvas.height * imgWidth) / canvas.width;
      var heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL("image/png", 1.0);
      let pdf = new jspdf("p", "mm", "a4"); // A4 size page of PDF
      var position = 0;
      pdf.addImage(contentDataURL, "PNG", 0, position, imgWidth, imgHeight);
      pdf.save("register-address/" + username + ".pdf"); // Generated PDF
    });

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
  ngOnInit() {
    this.personID = localStorage.getItem("personID");
  }
}
