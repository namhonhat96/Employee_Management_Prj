import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class AddContactService {
  constructor(private httpClient: HttpClient) {}

  registerContactTable(relationship, isReference, isEmergency) {
    return this.httpClient.post<any>("http://localhost:8081/onboard-contact", {
      relationship,
      isReference,
      isEmergency,
    });
  }
}
