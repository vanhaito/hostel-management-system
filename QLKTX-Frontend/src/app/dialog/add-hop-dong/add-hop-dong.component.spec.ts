import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddHopDongComponent } from './add-hop-dong.component';

describe('AddHopDongComponent', () => {
  let component: AddHopDongComponent;
  let fixture: ComponentFixture<AddHopDongComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddHopDongComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddHopDongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
