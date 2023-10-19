import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLuotThamComponent } from './add-luot-tham.component';

describe('AddLuotThamComponent', () => {
  let component: AddLuotThamComponent;
  let fixture: ComponentFixture<AddLuotThamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddLuotThamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLuotThamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
