import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonInfoHrComponent } from './person-info-hr.component';

describe('PersonInfoHrComponent', () => {
  let component: PersonInfoHrComponent;
  let fixture: ComponentFixture<PersonInfoHrComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonInfoHrComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonInfoHrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
