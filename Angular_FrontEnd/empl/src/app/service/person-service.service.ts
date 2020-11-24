import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { of } from "rxjs";
import { Person } from "./person";
@Injectable({
  providedIn: "root",
})
export class PersonServiceService {
  private baseUrl = "http://localhost:8081";
  constructor(private http: HttpClient) {}

  public findAllPersons(): Observable<any> {
    return this.http.get<Person[]>(`${this.baseUrl}` + "/onboard-person/list");
  }

  getPersonbyID(ID: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/onboard-person/${ID}`);
  }

  updatePerson(
    ID: any,
    firstname: any,
    lastname: any,
    middlename: any,
    email: any,
    cellphone: any,
    alternatephone: any,
    gender: any,
    SSN: any,
    DOB: any
  ) {
    return this.http.post<any>(
      "http://localhost:8081/onboard-person/update/" + ID.toString(),
      {
        ID,
        firstname,
        lastname,
        middlename,
        email,
        cellphone,
        alternatephone,
        gender,
        SSN,
        DOB,
      }
    );
  }
}
