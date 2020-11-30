import { Component, ViewChild, ElementRef, OnInit } from "@angular/core";
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
import { UploadService } from "./upload.service";

@Component({
  selector: "app-pdf-test",
  templateUrl: "./pdf-test.component.html",
  styleUrls: ["./pdf-test.component.css"],
})
export class PdfTestComponent implements OnInit {
  constructor(private http: HttpClient, private upload: UploadService) {}

  @ViewChild("content", { static: false }) content: ElementRef;

  @ViewChild("myFile", { static: false }) myFile: ElementRef;

  USERS = [
    {
      id: 1,
      name: "Leanne Graham",
      email: "sincere@april.biz",
      phone: "1-770-736-8031 x56442",
    },
    {
      id: 2,
      name: "Ervin Howell",
      email: "shanna@melissa.tv",
      phone: "010-692-6593 x09125",
    },
    {
      id: 3,
      name: "Clementine Bauch",
      email: "nathan@yesenia.net",
      phone: "1-463-123-4447",
    },
    {
      id: 4,
      name: "Patricia Lebsack",
      email: "julianne@kory.org",
      phone: "493-170-9623 x156",
    },
    {
      id: 5,
      name: "Chelsey Dietrich",
      email: "lucio@annie.ca",
      phone: "(254)954-1289",
    },
    {
      id: 6,
      name: "Mrs. Dennis",
      email: "karley@jasper.info",
      phone: "1-477-935-8478 x6430",
    },
  ];

  ngOnInit() {}
  // public openPDF(): void {
  //   let DATA = this.htmlData.nativeElement;
  //   let doc = new jspdf("p", "mm", "a4");
  //   doc.fromHTML(DATA.innerHTML, 15, 15);
  //   doc.output("dataurlnewwindow");
  // }

  generatePDF(name: string) {
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
      pdf.save(name + ".pdf"); // Generated PDF
    });
  }
}
