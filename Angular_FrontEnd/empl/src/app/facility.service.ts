import { Injectable } from "@angular/core";

import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { of } from "rxjs";
import { Facility } from "./facility";
import { housing } from "./mock-housing";
import { MessageService } from "./message.service";
import { FacilityComponent } from './facility/facility.component';

@Injectable({
  providedIn: "root",
})
export class HousingService {
  private baseUrl = "http://localhost:8081";
  constructor(
    private messageService: MessageService,
    private http: HttpClient
  ) {}

  public getHousing(): Observable<Facility[]> {
    // TODO: send the message _after_ fetching the housing
    return this.http.get<Facility[]>(`${this.baseUrl}` + "/house/list");
  }
  public updateHouse(
    ID: any,
    contactID: any,
    address: any,
    numberOfPerson: any
  ) {
    return this.http.post<any>(
      "http://localhost:8081/house/update/" + ID.toString(),
      {
        ID,
        contactID,
        address,
        numberOfPerson,
      }
    );
  }
}
