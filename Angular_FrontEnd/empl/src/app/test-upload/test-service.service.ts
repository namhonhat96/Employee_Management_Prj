import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class TestServiceService {
  private baseUrl = "http://localhost:8081";
  constructor(private http: HttpClient) {}

  public findAllFiles(): Observable<any> {
    return this.http.get<string[]>(`${this.baseUrl}` + "/files/list");
  }

  public uploadFile(file: any) {
    return this.http.post<any>("http://localhost:8081//files/upload/", {});
  }
}
