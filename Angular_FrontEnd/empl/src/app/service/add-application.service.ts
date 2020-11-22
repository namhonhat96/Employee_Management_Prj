import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class AddApplicationService {
  constructor(private httpClient: HttpClient) {}

  registerAppTable(employeeID, type) {
    return this.httpClient.post<any>("http://localhost:8081/onboard-app", {
      employeeID,
      type,
    });
  }
}
