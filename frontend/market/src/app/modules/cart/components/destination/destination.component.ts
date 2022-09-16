import {Component, OnDestroy, OnInit} from '@angular/core';

// @ngrx
import {select, Store} from "@ngrx/store";

//@rxjs
import {takeUntil} from "rxjs/operators";
import {Subject} from "rxjs";

import {AppState} from "../../../../core/@ngrx";
import {selectTask} from "../../@ngrx";
import {TaskModel} from "../../../../model/task";

@Component({
  selector: 'app-destination',
  templateUrl: './destination.component.html',
  styleUrls: ['./destination.component.css']
})
export class DestinationComponent implements OnInit, OnDestroy {

  task!: TaskModel;
  private componentDestroyed$: Subject<void> = new Subject<void>();

  constructor(
    private store: Store<AppState>
  ) {
  }

  ngOnInit(): void {
    let observer = {
      next: (task: TaskModel) => {
        this.task = {...task};
      },
      error(err: Error | string) {
        console.log(err);
      },
      complete() {
        console.log('Stream is completed')
      }
    };

    this.store.pipe(
      select(selectTask),
      takeUntil(this.componentDestroyed$)
    ).subscribe(observer);
  }

  ngOnDestroy(): void {
    this.componentDestroyed$.next();
    this.componentDestroyed$.complete();
  }

}
