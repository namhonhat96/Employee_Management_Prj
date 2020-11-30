import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilityReportingDetailComponent } from './facility-reporting-detail.component';

describe('FacilityReportingDetailComponent', () => {
  let component: FacilityReportingDetailComponent;
  let fixture: ComponentFixture<FacilityReportingDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacilityReportingDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilityReportingDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
