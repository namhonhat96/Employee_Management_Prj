import { Comment } from "./comment";
import { Report } from "./report";
import { REPORTS } from "./mock-reports";
import { Employee } from "./employee";

import { COMMENTS } from "./mock-comments";
import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class HousingService {
  constructor() {}

  getEmployeeList(): Observable<Employee[]> {
    //Get the real database
    return null;
  }

  getReportList(): Observable<Report[]> {
    //Get the real database
    return null;
  }

  getCommentList(): Observable<Comment[]> {
    //Get the real database
    return null;
  }
}
