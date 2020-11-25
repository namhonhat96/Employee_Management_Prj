import { Visa } from './../../home-page/visa/visa';
import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
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

  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `${this.baseUrl}/upload`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

  getFiles(): Observable<any> {
    return this.http.get(`${this.baseUrl}/files`);
  }
}