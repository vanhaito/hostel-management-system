import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NguoiComponent } from './nguoi.component';

describe('NguoiComponent', () => {
  let component: NguoiComponent;
  let fixture: ComponentFixture<NguoiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NguoiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NguoiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
