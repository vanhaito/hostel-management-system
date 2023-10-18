import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LuotGuiXeComponent } from './luot-gui-xe.component';

describe('LuotGuiXeComponent', () => {
  let component: LuotGuiXeComponent;
  let fixture: ComponentFixture<LuotGuiXeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LuotGuiXeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LuotGuiXeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
