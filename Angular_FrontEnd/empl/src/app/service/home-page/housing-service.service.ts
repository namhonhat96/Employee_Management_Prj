import { Housing } from './../../home-page/housing/housing';
import { Employment } from './../../home-page/personal-info/employment';

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HousingService {

  private baseUrl = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  public getHouseByID(ID: number): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/house/${ID}`);
  }

  updateHouse(ID: any, house: Housing) {
    return this.http.post<any>(
      'http://localhost:8081//house/update/' + ID.toString(), house
    );
  }
}