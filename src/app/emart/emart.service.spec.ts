import { TestBed } from '@angular/core/testing';

import { EmartService } from './emart.service';

describe('EmartService', () => {
  let service: EmartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
