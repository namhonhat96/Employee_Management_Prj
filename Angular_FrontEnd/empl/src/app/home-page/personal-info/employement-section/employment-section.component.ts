import { PersonalInfoService } from './../personal-info.service';
import { Employment } from './../employment';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employment-section',
  templateUrl: './employment-section.component.html',
  styleUrls: ['./employment-section.component.css']
})
export class EmploymentSectionComponent implements OnInit {
  info$: Observable<Employment>;

  constructor(private service: PersonalInfoService) { }

  ngOnInit(): void {
    this.info$ = this.service.getEmployment();
  }

}
