import { Report } from './../../home-page/housing/report';

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ReportService {

  private baseUrl = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  public getFacilityReportByID(ID: number): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-facility-report/${ID}`);
  }

  public getAllFacilityReport(): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-facility-report/list`);
  }

}