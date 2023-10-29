import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThongKeTongTienDichVuKtxTheoThangComponent } from './thong-ke-tong-tien-dich-vu-ktx-theo-thang.component';

describe('ThongKeTongTienDichVuKtxTheoThangComponent', () => {
  let component: ThongKeTongTienDichVuKtxTheoThangComponent;
  let fixture: ComponentFixture<ThongKeTongTienDichVuKtxTheoThangComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThongKeTongTienDichVuKtxTheoThangComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThongKeTongTienDichVuKtxTheoThangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
