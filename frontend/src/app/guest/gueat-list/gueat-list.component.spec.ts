import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GueatListComponent } from './gueat-list.component';

describe('GueatListComponent', () => {
  let component: GueatListComponent;
  let fixture: ComponentFixture<GueatListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GueatListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GueatListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
