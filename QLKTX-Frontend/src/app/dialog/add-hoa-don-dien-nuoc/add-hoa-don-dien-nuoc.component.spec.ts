import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddHoaDonDienNuocComponent } from './add-hoa-don-dien-nuoc.component';

describe('AddHoaDonDienNuocComponent', () => {
  let component: AddHoaDonDienNuocComponent;
  let fixture: ComponentFixture<AddHoaDonDienNuocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddHoaDonDienNuocComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddHoaDonDienNuocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
