import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class AddPersonService {
  constructor(private httpClient: HttpClient) {}

  registerPersonTable(
    id,
    firstname,
    lastname,
    middlename,
    email,
    cellphone,
    alternatephone,
    gender,
    SSN,
    DOB
  ) {
    return this.httpClient.post<any>("http://localhost:8081/onboard-person", {
      id,
      firstname,
      lastname,
      middlename,
      email,
      cellphone,
      alternatephone,
      gender,
      SSN,
      DOB,
    });
  }
}
