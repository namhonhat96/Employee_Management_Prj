import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterVisaComponent } from './register-visa.component';

describe('RegisterVisaComponent', () => {
  let component: RegisterVisaComponent;
  let fixture: ComponentFixture<RegisterVisaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterVisaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterVisaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
