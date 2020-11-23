import { EMERGENCYCONTACT } from './mock-emergencyContact';
import { CONTACTINFO } from './mock-contactInfo';

import { EmergencyContact } from './emergencyContact';
import { Employment } from './employment';
import { ContactInfo } from './contactInfo';
import { Address } from './address';
import { ADDRESS } from './mock-address';
import { Name } from './name';
import { NAME } from './mock-name';


import { Injectable } from "@angular/core";
import { Observable, of } from 'rxjs';
import { EMPLOYMENT } from './mock-employment';


@Injectable({
    providedIn: 'root',
})
export class PersonalInfoService {
    constructor(){}

    getName(): Observable<Name>
    {
        return of(NAME);
    }

    getAddress(): Observable<Address>
    {
        return of(ADDRESS);
    }

    getContactInfo(): Observable<ContactInfo>
    {
        return of(CONTACTINFO);
    }

    getEmployment(): Observable<Employment>
    {
        return of(EMPLOYMENT);
    }

    getEmergencyContact(): Observable<EmergencyContact>
    {
        return of(EMERGENCYCONTACT);
    }
}