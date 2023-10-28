import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThongKeTienDichVuSvTheoThangComponent } from './thong-ke-tien-dich-vu-sv-theo-thang.component';

describe('ThongKeTienDichVuSvTheoThangComponent', () => {
  let component: ThongKeTienDichVuSvTheoThangComponent;
  let fixture: ComponentFixture<ThongKeTienDichVuSvTheoThangComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThongKeTienDichVuSvTheoThangComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThongKeTienDichVuSvTheoThangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
