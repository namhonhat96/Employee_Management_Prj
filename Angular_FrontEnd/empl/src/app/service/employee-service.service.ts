import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { of } from "rxjs";
import { Employee } from "../home-page/housing/employee";

@Injectable({
  providedIn: "root",
})
export class EmployeeServiceService {
  private baseUrl = "http://localhost:8081";
  constructor(private http: HttpClient) {}

  public findAllEmployees(): Observable<any> {
    return this.http.get<Employee[]>(
      `${this.baseUrl}` + "/onboard-employee/list"
    );
  }

  getEmployeebyID(ID: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/onboard-employee/${ID}`);
  }

  updateEmployee(ID: any, name: any) {
    return this.http.post<any>(
      "http://localhost:8081/onboard-employee/update/" + ID.toString(),
      {
        ID,
        name,
      }
    );
  }
}
