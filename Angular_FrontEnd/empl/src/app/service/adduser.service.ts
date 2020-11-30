import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class AdduserService {
  constructor(private httpClient: HttpClient) {}

  registerUserTable(username, password, email, personID) {
    return this.httpClient
      .post<any>("http://localhost:8081/onboard-user", {
        username,
        password,
        email,
        personID,
      })
      .pipe(
        map((userData) => {
          sessionStorage.setItem("email", email);
          localStorage.setItem("username", username);
          let tokenStr = "Bearer " + userData.token;
          sessionStorage.setItem("token", tokenStr);
          return userData;
        })
      );
  }
}
