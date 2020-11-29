import { ReportDetail } from './../../home-page/housing/reportDetail';


import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ReportDetailService {

  private baseUrl = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  public getFacilityReportDetailByID(ID: number): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-facility-detail/${ID}`);
  }

  public getAllFacilityReportDetail(): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-facility-detail/list`);
  }
  
  public getAllFacilityReportDetailByReportID(ID: number): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-facility-detail/list/${ID}`);
  }

}
