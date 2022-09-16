import {Component, OnInit} from '@angular/core';
// @ngrx
import {select, Store} from "@ngrx/store";
//rxjs
import {Observable} from "rxjs";

import {AppState} from "../../../../core/@ngrx";
import {selectTasksData, selectTasksError} from "../../../@ngrx/tasks";
import * as TasksActions from "../../../@ngrx/tasks/tasks.action";
import {TaskModel, TaskStateEnum} from "../../../../model/task";

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  task$!: Observable<ReadonlyArray<TaskModel>>;
  errors$!: Observable<Error | string | null>;
  constructor(
    private store: Store<AppState>
  ) { }

  ngOnInit(): void {
    this.task$ = this.store.pipe(select(selectTasksData));
    this.errors$ = this.store.pipe(select(selectTasksError));
    this.store.dispatch(TasksActions.getTasks())
  }

  onNextState(oldTask: TaskModel) {
    let task = { ...oldTask};
    task.state = this.next(oldTask.state);
    this.store.dispatch(TasksActions.updateTask({ task }))
  }

  onReset(oldTask: TaskModel) {
    let task = { ...oldTask};
    task.state = TaskStateEnum.NEW;
    this.store.dispatch(TasksActions.updateTask({ task }))
  }

  isDone(task: TaskModel) {
    return task.state == TaskStateEnum.COMPLETED;
  }

  private next(value: TaskStateEnum): TaskStateEnum {
    if (value == TaskStateEnum.NEW) {
      return TaskStateEnum.IN_PROGRESS;
    }
    return TaskStateEnum.COMPLETED;
  }
}
