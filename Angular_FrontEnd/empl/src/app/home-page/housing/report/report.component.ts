import { Comment } from './../comment';
import { Report } from './../report';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HousingService } from '../housing.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  report$: Observable<Report[]>;
  comment$: Observable<Comment[]>;
  constructor(private service: HousingService) 
  { }

  ngOnInit(): void {
    this.report$ = this.service.getReportList();
    this.comment$ = this.service.getCommentList();
  }

}
