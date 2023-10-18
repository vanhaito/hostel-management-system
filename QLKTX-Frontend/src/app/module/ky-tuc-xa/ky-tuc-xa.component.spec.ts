import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KyTucXaComponent } from './ky-tuc-xa.component';

describe('KyTucXaComponent', () => {
  let component: KyTucXaComponent;
  let fixture: ComponentFixture<KyTucXaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KyTucXaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KyTucXaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
