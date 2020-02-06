import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListLeavingComponent } from './list-leaving.component';

describe('ListLeavingComponent', () => {
  let component: ListLeavingComponent;
  let fixture: ComponentFixture<ListLeavingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListLeavingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListLeavingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
