import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddKyTucXaComponent } from './add-ky-tuc-xa.component';

describe('AddKyTucXaComponent', () => {
  let component: AddKyTucXaComponent;
  let fixture: ComponentFixture<AddKyTucXaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddKyTucXaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddKyTucXaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
