import { TestBed } from '@angular/core/testing';

import { GiatLaService } from './giat-la.service';

describe('GiatLaService', () => {
  let service: GiatLaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GiatLaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
