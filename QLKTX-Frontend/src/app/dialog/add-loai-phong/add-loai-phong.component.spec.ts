import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLoaiPhongComponent } from './add-loai-phong.component';

describe('AddLoaiPhongComponent', () => {
  let component: AddLoaiPhongComponent;
  let fixture: ComponentFixture<AddLoaiPhongComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddLoaiPhongComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLoaiPhongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
