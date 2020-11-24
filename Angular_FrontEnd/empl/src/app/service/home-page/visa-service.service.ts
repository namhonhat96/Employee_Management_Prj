import { Visa } from './../../home-page/visa/visa';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class VisaService {

  private baseUrl = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  public getVisaByID(ID: number): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-visa-status/${ID}`);
  }

  updateVisa(ID: any, visa: Visa) {
    return this.http.post<any>(
      'http://localhost:8081/onboard-visa-status/update/' + ID.toString(), visa
    );
  }
}