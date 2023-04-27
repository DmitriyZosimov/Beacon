import { Injectable } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

import {Action} from "@ngrx/store";
import {Actions, createEffect, ofType} from '@ngrx/effects';

import {Observable, of} from "rxjs";
import {catchError, concatMap, map, pluck, switchMap} from "rxjs/operators";

import * as TasksActions from "./tasks.action";
import {TasksService} from "../../service";
import {TaskModel} from "../../../model/task";

@Injectable()
export class TasksEffects {

  constructor(
    private actions$: Actions,
    private tasksService: TasksService,
    private activatedRoute: ActivatedRoute
  ) {}

  getTasks$: Observable<Action> = createEffect(() =>
    this.actions$.pipe(
      ofType(TasksActions.getTasks),
      switchMap(action => {
        let shopId = this.activatedRoute.snapshot.firstChild?.firstChild?.url[0].path;
        return this.tasksService.getTasks(shopId!).pipe(
          map(tasks => TasksActions.getTasksSuccess({ tasks })),
          catchError(error => of(TasksActions.getTasksFailure({ error })))
        )
      })
    )
  )

  updateTask$: Observable<Action> = createEffect(() =>
    this.actions$.pipe(
      ofType(TasksActions.updateTask),
      pluck('task'),
      concatMap((task: TaskModel) => {
        let shopId = this.activatedRoute.snapshot.firstChild?.firstChild?.url[0].path;
        return this.tasksService.updateTask(shopId!, task).pipe(
          map(task => TasksActions.updateTaskSuccess({ task })),
          catchError(error => of(TasksActions.updateTaskFailure({ error })))
        )
      })
    )
  )
}
