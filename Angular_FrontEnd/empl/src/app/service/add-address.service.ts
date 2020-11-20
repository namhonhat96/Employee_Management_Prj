import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class AddAddressService {
  constructor(private httpClient: HttpClient) {}

  registerAddressTable(
    addressLine1,
    addressLine2,
    city,
    zipcode,
    stateName,
    stateAbbr,
    personID
  ) {
    return this.httpClient.post<any>("http://localhost:8081/onboard-address", {
      addressLine1,
      addressLine2,
      city,
      zipcode,
      stateName,
      stateAbbr,
      personID,
    });
  }
}
