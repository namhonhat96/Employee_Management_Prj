import { BoundElementPropertyAst } from "@angular/compiler";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AdduserService } from "../service/adduser.service";

@Component({
  selector: "app-register-user",
  templateUrl: "./register-user.component.html",
  styleUrls: ["./register-user.component.css"],
})
export class RegisterUserComponent implements OnInit {
  username: string | any;
  password: string | any;
  email: string | any;

  constructor(private router: Router, private addUserservice: AdduserService) {}

  registerUser() {
    this.addUserservice
      .registerUserTable(this.username, this.password, this.email)
      .subscribe(
        (data) => {
          localStorage.setItem("email", this.email);
          localStorage.setItem("username", this.username);
          localStorage.setItem("newuser", this.username);
          this.router.navigate([""]);
        },
        (error) => {}
      );
  }
  ngOnInit() {}
}
