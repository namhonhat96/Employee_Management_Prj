import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class AdduserService {
  constructor(private httpClient: HttpClient) {}

  registerUserTable(username, password, email) {
    return this.httpClient.post<any>("http://localhost:8081/onboard-user", {
      username,
      password,
      email,
    });
  }
}
