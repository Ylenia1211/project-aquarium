import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationPoolComponent } from './creation-pool.component';

describe('CreationPoolComponent', () => {
  let component: CreationPoolComponent;
  let fixture: ComponentFixture<CreationPoolComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreationPoolComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreationPoolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
