import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-visa',
  templateUrl: './visa.component.html',
  styleUrls: ['./visa.component.css']
})
export class VisaComponent implements OnInit {

  isCase1 = true;
  isCase2 = true;
  isCase3 = true;
  isCase4 = true;
  isCase5 = true;
  isCase6 = true;
  constructor() { }

  ngOnInit(): void {
  }

  getCase1(): boolean{
    return this.isCase1;
  }

  getCase2(): boolean{
    return this.isCase2;
  }

  getCase3(): boolean{
    return this.isCase3;
  }

  getCase4(): boolean{
    return this.isCase4;
  }

  getCase5(): boolean{
    return this.isCase5;
  }

  getCase6(): boolean{
    return this.isCase6;
  }

  
}
