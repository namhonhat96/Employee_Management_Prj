import { PersonalInfoService } from './../personal-info.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { EmergencyContact } from '../emergencyContact';

@Component({
  selector: 'app-emergency-contact',
  templateUrl: './emergency-contact.component.html',
  styleUrls: ['./emergency-contact.component.css']
})
export class EmergencyContactComponent implements OnInit {
  info$: Observable<EmergencyContact>;
  condition: boolean;
  constructor(private service: PersonalInfoService) { }

  ngOnInit(): void {
    this.info$ = this.service.getEmergencyContact();
    this.condition = false;
  }

  edit()
  {
    this.condition = !this.condition;
  }
}
