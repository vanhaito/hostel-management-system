import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddGiatLaComponent } from './add-giat-la.component';

describe('AddGiatLaComponent', () => {
  let component: AddGiatLaComponent;
  let fixture: ComponentFixture<AddGiatLaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddGiatLaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddGiatLaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
