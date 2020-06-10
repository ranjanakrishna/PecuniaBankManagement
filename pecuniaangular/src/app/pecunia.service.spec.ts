import { TestBed } from '@angular/core/testing';

import { PecuniaService } from './pecunia.service';

describe('PecuniaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PecuniaService = TestBed.get(PecuniaService);
    expect(service).toBeTruthy();
  });
});
