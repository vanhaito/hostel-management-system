import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddVeXeComponent } from './add-ve-xe.component';

describe('AddVeXeComponent', () => {
  let component: AddVeXeComponent;
  let fixture: ComponentFixture<AddVeXeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddVeXeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddVeXeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
