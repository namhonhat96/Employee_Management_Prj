import { Component, Input, OnInit } from '@angular/core';
import {Housing} from '../housing';
@Component({
  selector: 'app-housing-detail',
  templateUrl: './housing-detail.component.html',
  styleUrls: ['./housing-detail.component.css']
})
export class HousingDetailComponent implements OnInit {
 @Input() housing:Housing | undefined
  constructor() { }

  ngOnInit(): void {
  }

}
