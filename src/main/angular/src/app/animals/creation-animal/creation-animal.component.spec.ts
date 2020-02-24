import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationAnimalComponent } from './creation-animal.component';

describe('CreationAnimalComponent', () => {
  let component: CreationAnimalComponent;
  let fixture: ComponentFixture<CreationAnimalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreationAnimalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreationAnimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
