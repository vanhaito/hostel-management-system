import { TestBed } from '@angular/core/testing';

import { HopDongService } from './hop-dong.service';

describe('HopDongService', () => {
  let service: HopDongService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HopDongService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
