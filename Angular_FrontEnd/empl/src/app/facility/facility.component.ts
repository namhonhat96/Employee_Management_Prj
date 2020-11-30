import { Component, OnInit } from '@angular/core';

import { Facility } from '../facility';
import { HousingService } from '../housing.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-facility',
  templateUrl: './facility.component.html',
  styleUrls: ['./facility.component.css']
})
export class FacilityComponent implements OnInit {

  selectedFacility: Facility | undefined;

  facility: Facility[] | undefined;

  constructor(private FacilityService: FacilityService, private messageService: MessageService) { }

  ngOnInit() {
    this.getFacility();
  }

  onSelect(facility: Facility): void {
    this.selectedFacility = facility;
    this.messageService.add(`FacilityComponent: Selected facility id=${facility.facilityId}`);
  }

  getFacility(): void {
    this.facilityService.getFacility()
        .subscribe(facility => this.facility = facility);
  }
}
