import { Component, OnInit, Input } from "@angular/core";
import { Router } from "@angular/router";
import { AuthenticationService } from "../service/authentication.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  username = "";
  password = "";
  invalidLogin = false;

  @Input() error: string | null;

  constructor(
    private router: Router,
    private loginservice: AuthenticationService
  ) {}

  ngOnInit() {}

  checkLogin() {
    this.loginservice.authenticate(this.username, this.password).subscribe(
      (data) => {
        this.invalidLogin = false;
        localStorage.removeItem("username");
        localStorage.setItem("username", this.username);
        if (this.username == "admin") {
          this.router.navigate(["hr-home-page"]);
        } else {
          this.router.navigate(["home-page"]);
        }
      },
      (error) => {
        this.invalidLogin = true;
        this.error = "Invalid username/password";
      }
    );
  }
}
