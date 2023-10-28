import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NguoiSdtComponent } from './nguoi-sdt.component';

describe('NguoiSdtComponent', () => {
  let component: NguoiSdtComponent;
  let fixture: ComponentFixture<NguoiSdtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NguoiSdtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NguoiSdtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
