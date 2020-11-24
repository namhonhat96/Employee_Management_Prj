import { EmergencyContact } from './../../home-page/personal-info/emergencyContact';


import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmergencyContactService {

  private baseUrl = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  public getEmergencyContactByID(ID: number): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-contact/${ID}`);
  }

  updateEmergencyContact(ID: any, emergencyContact: EmergencyContact) {
    return this.http.post<any>(
      'http://localhost:8081/onboard-contact/update/' + ID.toString(), emergencyContact
    );
  }
}