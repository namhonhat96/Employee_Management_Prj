import { TestBed } from '@angular/core/testing';

import { VisaServiceService } from './visa-service.service';

describe('VisaServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VisaServiceService = TestBed.get(VisaServiceService);
    expect(service).toBeTruthy();
  });
});
