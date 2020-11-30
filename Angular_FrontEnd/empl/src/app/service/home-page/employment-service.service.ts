import { Employment } from './../../home-page/personal-info/employment';

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmploymentService {

  private baseUrl = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  public getEmploymentByID(ID: number): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-employee/${ID}`);
  }

  updateEmployment(ID: any, employment: Employment) {
    return this.http.post<any>(
      'http://localhost:8081/onboard-employee/update/' + ID.toString(), employment
    );
  }

  getEmployeeByHouseID(ID: number): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-employee/list/${ID}`);
  }
}
