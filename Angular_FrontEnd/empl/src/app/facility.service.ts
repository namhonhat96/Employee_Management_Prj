import { Injectable } from "@angular/core";

import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { of } from "rxjs";
import { Facility } from "./facility";
import { MessageService } from "./message.service";
import { FacilityComponent } from './facility/facility.component';

@Injectable({
  providedIn: "root",
})
export class FacilityService {
  private baseUrl = "http://localhost:8081";
  constructor(
    private messageService: MessageService,
    private http: HttpClient
  ) {}

  public getFacility(): Observable<Facility[]> {
    
    return this.http.get<Facility[]>(`${this.baseUrl}` + "/house/list");
  }
  public updateFacility(
    id: any,
    type: any,
    description: any,
    quantity: any,
    houseId: any
  ) {
    return this.http.post<any>(
      "http://localhost:8081/facility/update/" +id.toString(),
      {
        id,
        type,
        description,
        quantity,
        houseId,
      }
    );
  }
}
