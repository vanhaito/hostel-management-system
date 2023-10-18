import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeXeComponent } from './ve-xe.component';

describe('VeXeComponent', () => {
  let component: VeXeComponent;
  let fixture: ComponentFixture<VeXeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VeXeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VeXeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
