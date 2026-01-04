import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountActions } from './account-actions';

describe('AccountActions', () => {
  let component: AccountActions;
  let fixture: ComponentFixture<AccountActions>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccountActions]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AccountActions);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
