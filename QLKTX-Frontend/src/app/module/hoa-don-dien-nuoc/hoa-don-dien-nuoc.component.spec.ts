import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HoaDonDienNuocComponent } from './hoa-don-dien-nuoc.component';

describe('HoaDonDienNuocComponent', () => {
  let component: HoaDonDienNuocComponent;
  let fixture: ComponentFixture<HoaDonDienNuocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HoaDonDienNuocComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HoaDonDienNuocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
