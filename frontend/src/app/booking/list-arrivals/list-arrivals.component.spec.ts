import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListArrivalsComponent } from './list-arrivals.component';

describe('ListArrivalsComponent', () => {
  let component: ListArrivalsComponent;
  let fixture: ComponentFixture<ListArrivalsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListArrivalsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListArrivalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
