import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { of } from "rxjs";
@Injectable({
  providedIn: "root",
})
export class TokenService {
  private baseUrl = "http://localhost:8081";
  constructor(private httpClient: HttpClient) {}

  public createToken(
    token: string,
    validDuration: number,
    email: string,
    createdBy: string
  ) {
    return this.httpClient.post<any>("http://localhost:8081/reg_token", {
      token,
      validDuration,
      email,
      createdBy,
    });
  }
}
