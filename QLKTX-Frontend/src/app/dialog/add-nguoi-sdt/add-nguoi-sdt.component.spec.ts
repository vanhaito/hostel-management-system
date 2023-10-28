import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNguoiSdtComponent } from './add-nguoi-sdt.component';

describe('AddNguoiSdtComponent', () => {
  let component: AddNguoiSdtComponent;
  let fixture: ComponentFixture<AddNguoiSdtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNguoiSdtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNguoiSdtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
