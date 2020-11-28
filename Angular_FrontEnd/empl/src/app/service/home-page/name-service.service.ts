
import { Name } from '../../home-page/personal-info/name';

import { Address } from '../../home-page/personal-info/address';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class NameService {

  private baseUrl = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  public getNameByID(ID: number): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-person/${ID}`);
  }

  public getAllNames(): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-person/list`);
  }

  updateName(ID: any, name: Name) {
    return this.http.post<any>(
      'http://localhost:8081/onboard-person/update/' + ID.toString(), name
    );
  }
}
