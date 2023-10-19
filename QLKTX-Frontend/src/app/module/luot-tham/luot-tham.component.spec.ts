import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LuotThamComponent } from './luot-tham.component';

describe('LuotThamComponent', () => {
  let component: LuotThamComponent;
  let fixture: ComponentFixture<LuotThamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LuotThamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LuotThamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
