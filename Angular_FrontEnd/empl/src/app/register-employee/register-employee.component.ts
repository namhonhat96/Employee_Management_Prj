import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AddEmployeeService } from "../service/add-employee.service";
import { AddVisaService } from "../service/add-visa.service";
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
  selector: "app-register-employee",
  templateUrl: "./register-employee.component.html",
  styleUrls: ["./register-employee.component.css"],
})
export class RegisterEmployeeComponent implements OnInit {
  employeeID = this.randomInt(0, 1000);
  car: string | any;
  visaStartDate: string | any;
  visaEndDate: string | any;
  driverLisence: string | any;
  driver_exp: string | any;
  isResident: false;
  selectCitizen: string | any;
  personID = localStorage.getItem("personID");
  options = [
    { id: 1, valueData: true, name: "Yes" },
    { id: 2, valueData: false, name: "No" },
  ];

  constructor(
    private router: Router,
    private addEmployeeservice: AddEmployeeService,
    private AddVisaService: AddVisaService,
    private http: HttpClient,
    private upload: UploadService
  ) {}

  randomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  registerEmployee() {
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

    this.addEmployeeservice
      .registerEmployeeTable(
        this.employeeID,
        this.personID,
        this.car,
        this.visaStartDate,
        this.visaEndDate,
        this.driverLisence,
        this.driver_exp
      )
      .subscribe(
        (data) => {
          localStorage.setItem("employeeID", this.employeeID);
          if (!this.isResident) {
            this.router.navigate(["register-visa"]);
          } else {
            this.AddVisaService.registerVisa(
              this.selectCitizen,
              "false",
              localStorage.getItem("username")
            ).subscribe();
            //Finish the on-board application
            this.router.navigate(["login"]);
          }
        },
        (error) => {
          this.router.navigate[""];
        }
      );
  }

  ngOnInit() {}
}
