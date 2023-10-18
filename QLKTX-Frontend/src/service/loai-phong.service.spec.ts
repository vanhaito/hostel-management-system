import { TestBed } from '@angular/core/testing';

import { LoaiPhongService } from './loai-phong.service';

describe('LoaiPhongService', () => {
  let service: LoaiPhongService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoaiPhongService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
