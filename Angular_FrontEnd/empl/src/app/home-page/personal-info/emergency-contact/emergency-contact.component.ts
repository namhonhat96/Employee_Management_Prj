import { EmergencyContactService } from './../../../service/home-page/emergencyContact-service.service';

import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { EmergencyContact } from '../emergencyContact';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-emergency-contact',
  templateUrl: './emergency-contact.component.html',
  styleUrls: ['./emergency-contact.component.css']
})
export class EmergencyContactComponent implements OnInit {

  info$: EmergencyContact | any;
  condition: boolean;
  constructor(private service: EmergencyContactService, private router: Router) { }

  ngOnInit(): void {
    this.service.getEmergencyContactByID(1).subscribe((data) => {
      this.info$ = data;
    });
    this.condition = false;
  }

  edit()
  {
    this.condition = !this.condition;
    this.updateEmergencyContact();
  }

  updateEmergencyContact()
  {
    this.service.updateEmergencyContact(1, this.info$).subscribe(
      (data) => {
        this.router.navigate(['home-page/personal-info']);
      },
      (error) => {}
    );
    
  }
}
