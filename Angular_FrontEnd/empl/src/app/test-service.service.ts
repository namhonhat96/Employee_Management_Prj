import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Test } from '../app/test';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TestServiceService {
  private usersUrl: string;
  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/do-test';
  }

  public findAll(): Observable<Test[]> {
    return this.http.get<Test[]>('http://localhost:8080/do-test');
  }

  public save(user: Test) {
    return this.http.post<Test>(this.usersUrl, user);
  }
}
