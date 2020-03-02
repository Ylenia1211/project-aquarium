import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationSectorComponent } from './creation-sector.component';

describe('CreationSectorComponent', () => {
  let component: CreationSectorComponent;
  let fixture: ComponentFixture<CreationSectorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreationSectorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreationSectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
