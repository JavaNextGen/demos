import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodosDateComponent } from './todos-date.component';

describe('TodosDateComponent', () => {
  let component: TodosDateComponent;
  let fixture: ComponentFixture<TodosDateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TodosDateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TodosDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
