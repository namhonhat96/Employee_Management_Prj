import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { HousingService } from '../housing.service';

@Component({
  selector: 'app-house-detail',
  templateUrl: './house-detail.component.html',
  styleUrls: ['./house-detail.component.css']
})
export class HouseDetailComponent implements OnInit {
  address = '1 Dummy Street';
  /*employee$:{id: number, name: string, phone: string}[] = [
    { id: 1, name: 'Dragon Burning Cities', phone: '123465'},
    { id: 2, name: 'Sky Rains Great White Sharks', phone: '123465'},
    { id: 3, name: 'Giant Asteroid Heading For Earth', phone: '123465'},
    { id: 4, name: 'Procrastinators Meeting Delayed Again', phone: '123465'},
  ];*/
  employee$: Observable<Employee[]>;
  housingService: any;
  housing: any;
  router: any;

  constructor(
    private service: HousingService,
  ) {}

  ngOnInit(): void {}
  updateHouse() {
    this.housingService
      .updateHouse(
      this.housing.id,
      
        this.housing.contactID,
        this.housing.address,
        this.housing.numberOfPerson
      )
      .subscribe(
        (data) => {
          this.router.navigate(["hr-home-page/house-manage"]);
        },
        (error) => {}
      );
  }
}

