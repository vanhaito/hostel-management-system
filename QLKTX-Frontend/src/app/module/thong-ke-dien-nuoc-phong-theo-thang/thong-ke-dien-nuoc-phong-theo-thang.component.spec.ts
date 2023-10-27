import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThongKeDienNuocPhongTheoThangComponent } from './thong-ke-dien-nuoc-phong-theo-thang.component';

describe('ThongKeDienNuocPhongTheoThangComponent', () => {
  let component: ThongKeDienNuocPhongTheoThangComponent;
  let fixture: ComponentFixture<ThongKeDienNuocPhongTheoThangComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThongKeDienNuocPhongTheoThangComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThongKeDienNuocPhongTheoThangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
