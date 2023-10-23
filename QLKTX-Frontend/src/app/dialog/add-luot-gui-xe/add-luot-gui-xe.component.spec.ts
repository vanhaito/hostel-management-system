import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLuotGuiXeComponent } from './add-luot-gui-xe.component';

describe('AddLuotGuiXeComponent', () => {
  let component: AddLuotGuiXeComponent;
  let fixture: ComponentFixture<AddLuotGuiXeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddLuotGuiXeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLuotGuiXeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
