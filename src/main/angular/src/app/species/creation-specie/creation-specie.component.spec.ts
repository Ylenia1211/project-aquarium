import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationSpecieComponent } from './creation-specie.component';

describe('CreationSpecieComponent', () => {
  let component: CreationSpecieComponent;
  let fixture: ComponentFixture<CreationSpecieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreationSpecieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreationSpecieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
