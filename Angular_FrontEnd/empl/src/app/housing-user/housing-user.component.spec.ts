import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HousingUserComponent } from './housing-user.component';

describe('HousingUserComponent', () => {
  let component: HousingUserComponent;
  let fixture: ComponentFixture<HousingUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HousingUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HousingUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
