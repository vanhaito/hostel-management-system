import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KhachComponent } from './khach.component';

describe('KhachComponent', () => {
  let component: KhachComponent;
  let fixture: ComponentFixture<KhachComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KhachComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KhachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
