import { Component, OnInit } from '@angular/core';
// @ngrx
import {select, Store} from "@ngrx/store";
//rxjs
import {Observable} from "rxjs";

import {TaskModel} from "../../../models/task.model";
import {AppState} from "../../../../core/@ngrx";
import {selectTasksData, selectTasksError} from "../../../@ngrx/tasks";
import * as TasksActions from "../../../@ngrx/tasks/tasks.action";

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks$!: Observable<ReadonlyArray<TaskModel>>;
  errors$!: Observable<Error | string | null>;
  constructor(
    private store: Store<AppState>
  ) { }

  ngOnInit(): void {
    this.tasks$ = this.store.pipe(select(selectTasksData));
    this.errors$ = this.store.pipe(select(selectTasksError));
    this.store.dispatch(TasksActions.getTasks())
  }

  onDone(task: TaskModel) {
    task.isDone = true;
    this.store.dispatch(TasksActions.updateTask({task}))
  }

  onReset(task: TaskModel) {
    task.isDone = false;
    this.store.dispatch(TasksActions.updateTask({task}))
  }

}
