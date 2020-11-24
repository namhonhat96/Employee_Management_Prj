import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";

@Component({
  selector: "app-hire",
  templateUrl: "./hire.component.html",
  styleUrls: ["./hire.component.css"],
})
export class HireComponent implements OnInit {
  constructor(private http: HttpClient) {}
  email: string | any;
  tokenID: string | any;
  name = localStorage.getItem("username");
  ngOnInit() {}

  registerToken(contactForm: NgForm) {
    if (contactForm.valid) {
      const email = contactForm.value;
      const headers = new HttpHeaders({ "Content-Type": "application/json" });
      this.http
        .post(
          "https://formspree.io/asdlf7asdf",
          { name: this.name, replyto: this.email, message: this.tokenID },
          { headers: headers }
        )
        .subscribe((response) => {
          console.log(response);
        });
    }
  }
  //Register token to the datbase
}
