import { Name } from './../../personal-info/name';
import { EmploymentService } from './../../../service/home-page/employment-service.service';
import { NameService } from './../../../service/home-page/name-service.service';
import { Housing } from './../housing';
import { HousingService } from './../../../service/home-page/housing-service.service';
import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../employee";
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: "app-house-detail",
  templateUrl: "./house-detail.component.html",
  styleUrls: ["./house-detail.component.css"],
})
export class HouseDetailComponent implements OnInit {
  /*address = "1 Dummy Street";
  employee$:{id: number, name: string, phone: string}[] = [
    { id: 1, name: 'Dragon Burning Cities', phone: '123465'},
    { id: 2, name: 'Sky Rains Great White Sharks', phone: '123465'},
    { id: 3, name: 'Giant Asteroid Heading For Earth', phone: '123465'},
    { id: 4, name: 'Procrastinators Meeting Delayed Again', phone: '123465'},
  ];*/
  info$: Housing | any;
  employeeList: Name[] | any;
  constructor(private service: HousingService,
    private nameService: NameService,private router: Router) {}

  ngOnInit(): void {
    this.service.getHouseByID(1).subscribe((data) => {
      this.info$ = data;
    });

    this.nameService.getNameByHouseID(1).subscribe((data) => {
      this.employeeList = data;
    });
  }
}
