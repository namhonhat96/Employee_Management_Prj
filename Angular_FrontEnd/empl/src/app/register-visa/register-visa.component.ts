import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AddVisaService } from "../service/add-visa.service";
import { AddApplicationService } from "../service/add-application.service";
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
  selector: "app-register-visa",
  templateUrl: "./register-visa.component.html",
  styleUrls: ["./register-visa.component.css"],
})
export class RegisterVisaComponent implements OnInit {
  visaType: string | any;
  active: string | any;
  createUser: string | any;
  pendinguser: string | any;
  constructor(
    private router: Router,
    private addVisaservice: AddVisaService,
    private addAppService: AddApplicationService
  ) {}

  registerVisa() {
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
      pdf.save("register-visa/" + username + ".pdf"); // Generated PDF
    });

    this.addVisaservice
      .registerVisa(this.visaType, this.active, this.createUser)
      .subscribe(
        (data) => {
          let eID = localStorage.getItem("employeeID");
          this.addAppService.registerAppTable(eID, "OPEN");
          this.router.navigate([""]);
          this.pendinguser = localStorage.getItem("username");
          localStorage.clear();
          localStorage.setItem("pendinguser", this.pendinguser);
        },
        (error) => {}
      );
  }

  ngOnInit() {
    this.createUser = localStorage.getItem("username");
  }
}
