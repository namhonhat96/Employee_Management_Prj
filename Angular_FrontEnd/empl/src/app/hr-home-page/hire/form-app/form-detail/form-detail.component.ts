import { Component, OnInit } from "@angular/core";
import { Application } from "src/app/service/app";
import { ActivatedRoute, Params } from "@angular/router";
import { Subscription } from "rxjs/Subscription";
import { ApplicationService } from "src/app/service/application.service";
import { Router } from "@angular/router";
@Component({
  selector: "app-form-detail",
  templateUrl: "./form-detail.component.html",
  styleUrls: ["./form-detail.component.css"],
})
export class FormDetailComponent implements OnInit {
  app: { id: number; status: string; comments: string };
  paramsSubscription: Subscription;

  constructor(
    private route: ActivatedRoute,
    private appService: ApplicationService,
    private router: Router
  ) {}

  ngOnInit() {
    this.app = {
      id: this.route.snapshot.params["id"],
      status: localStorage.get("appStatus"),
      comments: localStorage.get("appComments"),
    };
    this.paramsSubscription = this.route.params.subscribe((params: Params) => {
      this.app.id = params["id"];
      this.app.status = localStorage.get("appStatus");
      this.app.comments = localStorage.get("appComments");
    });
  }

  updateApp() {
    this.appService
      .updateApp(this.app.id, this.app.status, this.app.comments)
      .subscribe(
        (data) => {
          this.router.navigate(["hr-home-page/hire"]);
        },
        (error) => {}
      );
  }
}
