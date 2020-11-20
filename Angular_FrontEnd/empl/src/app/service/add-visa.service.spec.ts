import { TestBed } from '@angular/core/testing';

import { AddVisaService } from './add-visa.service';

describe('AddVisaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddVisaService = TestBed.get(AddVisaService);
    expect(service).toBeTruthy();
  });
});
