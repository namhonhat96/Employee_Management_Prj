import { Comment } from './comment';
import { Report } from './report';
import { REPORTS } from './mock-reports';
import { Employee } from './employee';
import { EMPLOYEES } from './mock-employees';

import { COMMENTS } from './mock-comments';
import { Injectable } from "@angular/core";
import { Observable, of } from 'rxjs';


@Injectable({
    providedIn: 'root',
})
export class HousingService {
    constructor(){}

    getEmployeeList(): Observable<Employee[]>{
        return of(EMPLOYEES);
    }
    
    getReportList(): Observable<Report[]>{
        return of(REPORTS);
    }

    getCommentList(): Observable<Comment[]>{
        return of(COMMENTS);
    }
}