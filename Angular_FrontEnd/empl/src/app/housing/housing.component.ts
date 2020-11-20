import { Component, OnInit } from '@angular/core';
import {Housing} from '../housing';

@Component({
  selector: 'app-housing',
  templateUrl: './housing.component.html',
  styleUrls: ['./housing.component.css']
})
export class HousingComponent implements OnInit {



  housing: Housing = {
    housingId: 1,
    housingName: 'Princeton'
  };

  constructor() {

  }

  ngOnInit(): void {
  }

}
