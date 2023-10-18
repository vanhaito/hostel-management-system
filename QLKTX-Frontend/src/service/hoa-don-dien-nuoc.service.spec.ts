import { TestBed } from '@angular/core/testing';

import { HoaDonDienNuocService } from './hoa-don-dien-nuoc.service';

describe('HoaDonDienNuocService', () => {
  let service: HoaDonDienNuocService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HoaDonDienNuocService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
