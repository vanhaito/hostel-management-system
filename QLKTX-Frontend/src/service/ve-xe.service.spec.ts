import { TestBed } from '@angular/core/testing';

import { VeXeService } from './ve-xe.service';

describe('VeXeService', () => {
  let service: VeXeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VeXeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
