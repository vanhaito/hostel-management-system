import { TestBed } from '@angular/core/testing';

import { NhanVienQlService } from './nhan-vien-ql.service';

describe('NhanVienQlService', () => {
  let service: NhanVienQlService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NhanVienQlService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
