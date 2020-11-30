import { NameService } from '../../../service/home-page/name-service.service';
import { Name } from './../name';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-name-section',
  templateUrl: './name-section.component.html',
  styleUrls: ['./name-section.component.css']
})
export class NameSectionComponent implements OnInit {
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
    this.updateName();
  }

  updateName()
  {
    this.service.updateName(1, this.info$).subscribe(
      (data) => {
        this.router.navigate(['home-page-/person-info']);
      },
      (error) => {}
    );
  }
}
