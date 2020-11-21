import { PersonalInfoService } from './../personal-info.service';
import { ContactInfo } from './../contactInfo';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact-info-section',
  templateUrl: './contact-info-section.component.html',
  styleUrls: ['./contact-info-section.component.css']
})
export class ContactInfoSectionComponent implements OnInit {
  info$: Observable<ContactInfo>;
  constructor(private service: PersonalInfoService) { }

  ngOnInit(): void {
    this.info$ = this.service.getContactInfo();
  }

}
