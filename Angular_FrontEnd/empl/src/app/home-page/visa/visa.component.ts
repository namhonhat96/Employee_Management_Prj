import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-visa',
  templateUrl: './visa.component.html',
  styleUrls: ['./visa.component.css']
})
export class VisaComponent implements OnInit {

  isCase1: boolean;
  isCase2 : boolean;
  isCase3 : boolean;
  isCase4 : boolean;
  isCase5 : boolean;
  isCase6 : boolean;
  constructor() { }

  ngOnInit(): void {
    this.service.getVisaByID(1).subscribe((data) => {
      this.info$ = data;
    });

    this.isCase2 = true;
    this.isCase3 = true;
    this.isCase4 = true;
    this.isCase5 = true;
    this.isCase6 = true;
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
