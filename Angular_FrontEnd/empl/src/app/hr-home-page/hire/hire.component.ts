import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { TokenService } from "src/app/service/token.service";
import { Router } from "@angular/router";
@Component({
  selector: "app-hire",
  templateUrl: "./hire.component.html",
  styleUrls: ["./hire.component.css"],
})
export class HireComponent implements OnInit {
  constructor(private router: Router, private tokenService: TokenService) {}
  tokenID: string | any;
  validDuration = "ACTIVE";
  email: string | any;
  createdBy = localStorage.getItem("username");
  ngOnInit() {}

  registerToken() {
    this.tokenService
      .createToken(this.tokenID, this.validDuration, this.email, this.createdBy)
      .subscribe(
        (data) => {
          this.router.navigate(["hr-home-page/hire"]);
        },
        (error) => {}
      );
  }
}
