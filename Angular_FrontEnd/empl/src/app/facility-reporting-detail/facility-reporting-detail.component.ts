import { Component, Input, OnInit } from "@angular/core";
import { ActivatedRoute, Params, Router } from "@angular/router";
import { Facility } from '../facility';
//import { facility } from "../facility";
import { FacilityService } from "../facility.service";
@Component({
  selector: "app-facility-detail",
  templateUrl: "./facility-detail.component.html",
  styleUrls: ["./facility-detail.component.css"],
})
export class FacilityReportingDetailComponent implements OnInit {
  @Input() facility: Facility | undefined;

  constructor(private router: Router, private facilityService: FacilityService) {}

  ngOnInit(): void {}
  updateFacility() {
    this.facilityService
      .updateFacility(
        this.facility.id,
        this.facility.type,
        this.facility.quantity,
        this.facility.houseId,
        this.facility.description
      )
      .subscribe(
        (data) => {
          this.router.navigate(["hr-home-page/house-manage"]);
        },
        (error) => {}
      );
  }
}
