import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class AddEmployeeService {
  constructor(private httpClient: HttpClient) {}

  registerEmployeeTable(
    personID,
    car,
    visaStartDate,
    visaEndDate,
    driverLisence,
    driver_exp
  ) {
    return this.httpClient.post<any>("http://localhost:8081/onboard-employee", {
      personID,
      car,
      visaStartDate,
      visaEndDate,
      driverLisence,
      driver_exp,
    });
  }
}
