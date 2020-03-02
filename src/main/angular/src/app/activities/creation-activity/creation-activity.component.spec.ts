import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationActivityComponent } from './creation-activity.component';

describe('CreationActivityComponent', () => {
  let component: CreationActivityComponent;
  let fixture: ComponentFixture<CreationActivityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreationActivityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreationActivityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
