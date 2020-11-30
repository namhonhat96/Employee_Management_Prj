import { Component, OnInit } from "@angular/core";
import { Facility } from "../facility";
import { FacilityService } from "../service/facility.service";
import { MessageService } from "../service/message.service";

@Component({
  selector: "app-facility",
  templateUrl: "./facility.component.html",
  styleUrls: ["./facility.component.css"],
})
export class FacilityComponent implements OnInit {
  selectedFacility: Facility | undefined;

  facility: Facility[] | undefined;

  constructor(
    private facilityService: FacilityService,
    private messageService: MessageService
  ) {}

  ngOnInit() {
    this.getFacility();
  }

  onSelect(facility: Facility): void {
    this.selectedFacility = facility;
    this.messageService.add(
      `FacilityComponent: Selected facility id=${facility.id}`
    );
  }

  getFacility(): void {
    this.facilityService
      .getFacility()
      .subscribe((facility) => (this.facility = facility));
  }
}
