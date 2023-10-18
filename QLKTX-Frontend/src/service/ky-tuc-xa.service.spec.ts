import { TestBed } from '@angular/core/testing';

import { KyTucXaService } from './ky-tuc-xa.service';

describe('KyTucXaService', () => {
  let service: KyTucXaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KyTucXaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
