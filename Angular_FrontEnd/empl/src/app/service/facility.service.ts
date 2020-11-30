import { Injectable } from "@angular/core";

import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { of } from "rxjs";
import { MessageService } from "./message.service";
import { Facility } from "../facility";

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
    return this.http.get<Facility[]>(
      `${this.baseUrl}` + "/onboard-facility-report/list"
    );
  }

  public updateFacility(
    id: any,
    type: any,
    description: any,
    quantity: any,
    houseId: any
  ) {
    return this.http.post<any>(
      "http://localhost:8081/facility/update/" + id.toString(),
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
