import { TestBed } from '@angular/core/testing';

import { LuotThamService } from './luot-tham.service';

describe('LuotThamService', () => {
  let service: LuotThamService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LuotThamService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
