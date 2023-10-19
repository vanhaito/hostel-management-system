import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSinhVienComponent } from './add-sinh-vien.component';

describe('AddSinhVienComponent', () => {
  let component: AddSinhVienComponent;
  let fixture: ComponentFixture<AddSinhVienComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddSinhVienComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSinhVienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
