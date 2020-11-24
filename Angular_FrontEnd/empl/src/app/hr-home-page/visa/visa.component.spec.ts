import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { VisaHRComponent } from "./visa.component";

describe("VisaComponent", () => {
  let component: VisaHRComponent;
  let fixture: ComponentFixture<VisaHRComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [VisaHRComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisaHRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
