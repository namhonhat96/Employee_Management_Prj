import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocAppComponent } from './doc-app.component';

describe('DocAppComponent', () => {
  let component: DocAppComponent;
  let fixture: ComponentFixture<DocAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
