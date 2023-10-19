import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NhanVienQuanLyComponent } from './nhan-vien-quan-ly.component';

describe('NhanVienQuanLyComponent', () => {
  let component: NhanVienQuanLyComponent;
  let fixture: ComponentFixture<NhanVienQuanLyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NhanVienQuanLyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NhanVienQuanLyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
