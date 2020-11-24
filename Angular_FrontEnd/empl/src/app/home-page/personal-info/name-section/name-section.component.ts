import { PersonalInfoService } from './../personal-info.service';
import { Name } from './../name';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-name-section',
  templateUrl: './name-section.component.html',
  styleUrls: ['./name-section.component.css']
})
export class NameSectionComponent implements OnInit {
  info$: Observable<Name>;
  condition: boolean;
  constructor(private service: PersonalInfoService) { }

  ngOnInit(): void {
    this.info$ = this.service.getName();
    this.condition = false;
  }

  edit()
  {
    this.condition = !this.condition;
  }

}
