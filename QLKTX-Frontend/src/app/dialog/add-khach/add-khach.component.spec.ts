import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddKhachComponent } from './add-khach.component';

describe('AddKhachComponent', () => {
  let component: AddKhachComponent;
  let fixture: ComponentFixture<AddKhachComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddKhachComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddKhachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
