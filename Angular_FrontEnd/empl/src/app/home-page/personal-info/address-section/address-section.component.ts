import { Address } from './../address';

import { Observable } from 'rxjs';
import { PersonalInfoService } from '../personal-info.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-address-section',
  templateUrl: './address-section.component.html',
  styleUrls: ['./address-section.component.css']
})
export class AddressSectionComponent implements OnInit {
  info$: Observable<Address>;

  constructor(private service: PersonalInfoService) { }

  ngOnInit(): void {
    this.info$ = this.service.getAddress();
  }

}
