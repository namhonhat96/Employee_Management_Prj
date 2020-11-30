import { Component, OnInit } from "@angular/core";
import { Application } from "src/app/service/app";
import { ApplicationService } from "src/app/service/application.service";

@Component({
  selector: "app-form-app",
  templateUrl: "./form-app.component.html",
  styleUrls: ["./form-app.component.css"],
})
export class FormAppComponent implements OnInit {
  appForms: Application[] = [];

  constructor(private appService: ApplicationService) {}

  ngOnInit() {
    this.appService.findAllApplications().subscribe((data) => {
      this.appForms = data;
    });
  }
}
