import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { of } from "rxjs";
import { Visa } from "./visa";

@Injectable({
  providedIn: "root",
})
export class VisaServiceService {
  private baseUrl = "http://localhost:8081";
  constructor(private http: HttpClient) {}

  public findAllVisas(): Observable<any> {
    return this.http.get<Visa[]>(
      `${this.baseUrl}` + "/onboard-visa-status/list"
    );
  }

  getVisabyID(ID: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/onboard-visa-status/${ID}`);
  }

  updateVisa(
    id: number,
    visaType: string,
    active: string,
    modificationDate: string,
    createUser: string
  ) {
    return this.http.post<any>(
      "http://localhost:8081/onboard-visa-status/update/" + id.toString(),
      {
        id,
        visaType,
        active,
        modificationDate,
        createUser,
      }
    );
  }
}
