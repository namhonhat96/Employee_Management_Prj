import { VisaService } from './../../service/home-page/visa-service.service';
import { Component, OnInit } from '@angular/core';
import { Visa } from './visa';
import { ActivatedRoute, Params, Router } from '@angular/router';
@Component({
  selector: 'app-visa',
  templateUrl: './visa.component.html',
  styleUrls: ['./visa.component.css']
})
export class VisaComponent implements OnInit {
  info$: Visa | any;

  /*isCase1: boolean;
  isCase2 : boolean;
  isCase3 : boolean;
  isCase4 : boolean;
  isCase5 : boolean;
  isCase6 : boolean;*/
  constructor(private service: VisaService, private router: Router) { }

  ngOnInit(): void {
    this.service.getVisaByID(1).subscribe((data) => {
      this.info$ = data;
    });

    /*this.isCase1 = true;
    this.isCase2 = true;
    this.isCase3 = true;
    this.isCase4 = true;
    this.isCase5 = true;
    this.isCase6 = true;*/
  }

  updateVisa()
  {
    this.service.updateVisa(1, this.info$).subscribe(
      (data) => {
        this.router.navigate(['home-page-/visa']);
      },
      (error) => {}
    );
  }
}  