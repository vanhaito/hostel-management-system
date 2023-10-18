import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GiatLaComponent } from './giat-la.component';

describe('GiatLaComponent', () => {
  let component: GiatLaComponent;
  let fixture: ComponentFixture<GiatLaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GiatLaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GiatLaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
