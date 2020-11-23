import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";
@Injectable({
  providedIn: "root",
})
export class AddVisaService {
  constructor(private httpClient: HttpClient) {}

  registerVisa(visaType, active, createUser) {
    return this.httpClient.post<any>(
      "http://localhost:8081/onboard-visa-status",
      { visaType, active, createUser }
    );
  }
}
