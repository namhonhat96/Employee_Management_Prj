import { Component, ElementRef, OnInit, ViewChild } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { AddPersonService } from "../service/add-person.service";
import { Gender } from "./gender";
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
import { UploadService } from "../pdf-test/upload.service";
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
  genderNumber: number;
  ssn: string | any;
  dob: string | any;
  gender_options: Gender[] = [];

  constructor(
    private router: Router,
    private addPersonservice: AddPersonService,
    private http: HttpClient,
    private upload: UploadService
  ) {}

  getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
  }

  registerPerson() {
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
      pdf.save("register-person/" + username + ".pdf"); // Generated PDF
    });

    this.gender = "Male";
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
        this.ssn,
        this.dob
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
    this.id = localStorage.getItem("personID");
    this.gender_options = [
      { id: 1, name: "Male" },
      { id: 2, name: "Female" },
      { id: 3, name: "I don't want to answer" },
    ];
  }
}
