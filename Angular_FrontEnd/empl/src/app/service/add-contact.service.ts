import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class AddContactService {
  constructor(private httpClient: HttpClient) {}

  registerContactTable(personID, relationship, isReference, isEmergency) {
    return this.httpClient.post<any>("http://localhost:8081/onboard-contact", {
      personID,
      relationship,
      isReference,
      isEmergency,
    });
  }
}
