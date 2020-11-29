import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AddContactService } from "../service/add-contact.service";
import { FormBuilder, FormGroup } from "@angular/forms";
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
import { UploadService } from "../pdf-test/upload.service";

@Component({
  selector: "app-register-contact",
  templateUrl: "./register-contact.component.html",
  styleUrls: ["./register-contact.component.css"],
})
export class RegisterContactComponent implements OnInit {
  relationship: string | any;
  isReference: string | any;
  isEmergency: string | any;
  personID = localStorage.getItem("personID");
  constructor(
    private router: Router,
    private addContactservice: AddContactService,
    private http: HttpClient,
    private upload: UploadService
  ) {}

  registerContact() {
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
      pdf.save("register-contact/" + username + ".pdf"); // Generated PDF
    });

    this.addContactservice
      .registerContactTable(
        this.personID,
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
