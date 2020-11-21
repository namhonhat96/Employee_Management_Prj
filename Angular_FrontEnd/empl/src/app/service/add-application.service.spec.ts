import { TestBed } from '@angular/core/testing';

import { AddApplicationService } from './add-application.service';

describe('AddApplicationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddApplicationService = TestBed.get(AddApplicationService);
    expect(service).toBeTruthy();
  });
});
