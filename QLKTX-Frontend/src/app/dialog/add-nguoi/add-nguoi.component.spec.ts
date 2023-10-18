import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNguoiComponent } from './add-nguoi.component';

describe('AddNguoiComponent', () => {
  let component: AddNguoiComponent;
  let fixture: ComponentFixture<AddNguoiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNguoiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNguoiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
