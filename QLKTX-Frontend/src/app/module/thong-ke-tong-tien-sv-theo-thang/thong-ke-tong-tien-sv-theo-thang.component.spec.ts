import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThongKeTongTienSvTheoThangComponent } from './thong-ke-tong-tien-sv-theo-thang.component';

describe('ThongKeTongTienSvTheoThangComponent', () => {
  let component: ThongKeTongTienSvTheoThangComponent;
  let fixture: ComponentFixture<ThongKeTongTienSvTheoThangComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThongKeTongTienSvTheoThangComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThongKeTongTienSvTheoThangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
