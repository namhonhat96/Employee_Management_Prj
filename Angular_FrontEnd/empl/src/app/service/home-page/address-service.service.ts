
import { Address } from '../../home-page/personal-info/address';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AddressServiceService {

  private baseUrl = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  public getAddressByID(ID: number): Observable<Object>
  {
    return this.http.get(`${this.baseUrl}/onboard-address/${ID}`);
  }

  updateAddress(ID: any, address: Address) {
    return this.http.post<any>(
      'http://localhost:8081/updatetest/' + ID.toString(), address
    );
  }
}
