import { TestBed } from '@angular/core/testing';

import { KhachService } from './khach.service';

describe('KhachService', () => {
  let service: KhachService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KhachService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
