import { ReportDetailService } from './../../../service/home-page/reportDetail-service.service';
import { ReportDetail } from './../reportDetail';
import { ReportService } from './../../../service/home-page/report-service.service';
import { HousingService } from './../../../service/home-page/housing-service.service';

import { Report } from './../report';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  /*report$: Observable<Report[]>;
  comment$: Observable<Comment[]>;*/
  reportList$: Report[] | any;
  reportDetailList$: ReportDetail[] | any;
  constructor(private service: ReportService,
    private reportDetailService: ReportDetailService, private router: Router) 
  { }

  ngOnInit(): void {
    /*this.report$ = this.service.getReportList();
    this.comment$ = this.service.getCommentList();*/
    this.service.getAllFacilityReport().subscribe((data) => {
      this.reportList$ = data;
    });
    /*this.reportDetailService.getAllFacilityReportDetail().subscribe((data) => {
      this.reportDetailList$ = data;
    });*/
  }

}
