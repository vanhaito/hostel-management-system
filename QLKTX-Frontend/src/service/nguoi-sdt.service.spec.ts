import { TestBed } from '@angular/core/testing';

import { NguoiSdtService } from './nguoi-sdt.service';

describe('NguoiSdtService', () => {
  let service: NguoiSdtService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NguoiSdtService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
