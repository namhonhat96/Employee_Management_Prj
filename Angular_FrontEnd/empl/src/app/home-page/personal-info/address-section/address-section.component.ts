import { AddressService } from './../../../service/home-page/address-service.service';
import { Address } from './../address';

import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-address-section',
  templateUrl: './address-section.component.html',
  styleUrls: ['./address-section.component.css']
})
export class AddressSectionComponent implements OnInit {
  //info$: Observable<Address>;
  info$: Address | any;
  secondInfo$: Address | any;
  condition: boolean;

  constructor(private service: AddressService,
    private router: Router) { }

  ngOnInit(): void {
    this.service.getAddressByID(1).subscribe((data) => {
      this.info$ = data;
    });
    this.service.getAddressByID(2).subscribe((data) => {
      this.secondInfo$ = data;
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
    this.service.updateAddress(1, this.info$).subscribe(
      (data) => {
      
      },
      (error) => {}
    );
    this.service.updateAddress(2, this.secondInfo$).subscribe(
      (data) => {
        this.router.navigate(['home-page/personal-info']);
      },
      (error) => {}
    );
  }

}
