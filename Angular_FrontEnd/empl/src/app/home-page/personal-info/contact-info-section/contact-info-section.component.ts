import { NameService } from './../../../service/home-page/name-service.service';
import { Name } from './../name';


import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-contact-info-section',
  templateUrl: './contact-info-section.component.html',
  styleUrls: ['./contact-info-section.component.css']
})
export class ContactInfoSectionComponent implements OnInit {
  info$: Name | any;
  condition: boolean;
  constructor(private service: NameService, private router: Router) { }

  ngOnInit(): void {
    this.service.getNameByID(1).subscribe((data) => {
      this.info$ = data;
    });
    this.condition = false;
  }

  edit()
  {
    this.condition = !this.condition;
    this.updateContactInfo();
  }

  updateContactInfo()
  {
    this.service.updateName(1, this.info$).subscribe(
      (data) => {
        this.router.navigate(['home-page/personal-info']);
      },
      (error) => {}
    );
  }
}
