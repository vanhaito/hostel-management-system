import { TestBed } from '@angular/core/testing';

import { LuotGuiXeService } from './luot-gui-xe.service';

describe('LuotGuiXeService', () => {
  let service: LuotGuiXeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LuotGuiXeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
