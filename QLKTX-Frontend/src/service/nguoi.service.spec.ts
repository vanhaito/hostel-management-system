import { TestBed } from '@angular/core/testing';

import { NguoiService } from './nguoi.service';

describe('NguoiService', () => {
  let service: NguoiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NguoiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
