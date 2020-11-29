import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { of } from "rxjs";
import { Application } from "./app";
@Injectable({
  providedIn: "root",
})
export class ApplicationService {
  private baseUrl = "http://localhost:8081";
  constructor(private http: HttpClient) {}

  public findAllApplications(): Observable<any> {
    return this.http.get<Application[]>(
      `${this.baseUrl}` + "/onboard-app/list"
    );
  }

  public updateApp(ID: any, status: string, comments: string) {
    return this.http.post<any>(
      "http://localhost:8081/onboard-app/update/" + ID.toString(),
      {
        ID,
        status,
        comments,
      }
    );
  }

  public getAppById(ID: any) {
    return this.http.get(`${this.baseUrl}/onboard-app/${ID}`);
  }
}
