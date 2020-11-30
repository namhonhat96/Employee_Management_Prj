import { BoundElementPropertyAst } from "@angular/compiler";
import { Component, ElementRef, OnInit, ViewChild } from "@angular/core";
import { Router } from "@angular/router";
import { AdduserService } from "../service/adduser.service";
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
  selector: "app-register-user",
  templateUrl: "./register-user.component.html",
  styleUrls: ["./register-user.component.css"],
})
export class RegisterUserComponent implements OnInit {
  username: string | any;
  password: string | any;
  email: string | any;
  personID: number | any;

  constructor(
    private router: Router,
    private addUserservice: AdduserService,
    private http: HttpClient,
    private upload: UploadService
  ) {}

  getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
  }

  registerUser() {
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
      pdf.save("register-user/" + this.username + ".pdf"); // Generated PDF
    });

    this.personID = this.getRandomInt(1000);
    this.addUserservice
      .registerUserTable(
        this.username,
        this.password,
        this.email,
        this.personID
      )
      .subscribe(
        (data) => {
          localStorage.setItem("email", this.email);
          localStorage.setItem("username", this.username);
          localStorage.setItem("newuser", this.username);
          localStorage.setItem("newuser", this.username);
          localStorage.setItem("personID", this.personID);
          this.router.navigate([""]);
        },
        (error) => {}
      );
  }

  ngOnInit() {}
}
