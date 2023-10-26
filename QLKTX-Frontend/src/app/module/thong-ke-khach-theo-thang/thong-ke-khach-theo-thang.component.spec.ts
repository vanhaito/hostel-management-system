import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThongKeKhachTheoThangComponent } from './thong-ke-khach-theo-thang.component';

describe('ThongKeKhachTheoThangComponent', () => {
  let component: ThongKeKhachTheoThangComponent;
  let fixture: ComponentFixture<ThongKeKhachTheoThangComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThongKeKhachTheoThangComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThongKeKhachTheoThangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
