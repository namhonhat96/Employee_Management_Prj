import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';

import { Housing } from './housing';
import { housing } from './mock-housing';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root',
})
export class HousingService {

  constructor(private messageService: MessageService) { }

  getHousing(): Observable<Housing[]> {
    // TODO: send the message _after_ fetching the housing
    this.messageService.add('HousingService: fetched housing');
    return of(housing);
  }
}
