import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNhanVienQlComponent } from './add-nhan-vien-ql.component';

describe('AddNhanVienQlComponent', () => {
  let component: AddNhanVienQlComponent;
  let fixture: ComponentFixture<AddNhanVienQlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNhanVienQlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNhanVienQlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
