import { EmploymentService } from './../../../service/home-page/employment-service.service';

import { Employment } from './../employment';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-employment-section',
  templateUrl: './employment-section.component.html',
  styleUrls: ['./employment-section.component.css']
})
export class EmploymentSectionComponent implements OnInit {
  info$: Employment | any;
  condition: boolean;
  constructor(private service: EmploymentService, private router: Router) { }

  ngOnInit(): void {
    this.service.getEmploymentByID(1).subscribe((data) => {
      this.info$ = data;
    });
    this.condition = false;
  }

  edit()
  {
    this.condition = !this.condition;
    this.updateEmployment();
  }

  updateEmployment()
  {
    this.service.updateEmployment(1, this.info$).subscribe(
      (data) => {
        this.router.navigate(['home-page/personal-info']);
      },
      (error) => {}
    );
  }
}
