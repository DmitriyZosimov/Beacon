import {Component, OnDestroy, OnInit} from '@angular/core';
// @ngrx
import {select, Store} from "@ngrx/store";

// @rxjs
import {Subject} from "rxjs";
import {takeUntil} from "rxjs/operators";

import {AppState} from "../../../../core/@ngrx";
import * as CartActions from '../../@ngrx/cart.actions';
import {TaskModel} from "../../../../model/task";
import {selectTask} from "../../@ngrx";

@Component({
  selector: 'app-cart-from',
  templateUrl: './cart-from.component.html',
  styleUrls: ['./cart-from.component.css']
})
export class CartFromComponent implements OnInit, OnDestroy {

  task!: TaskModel;

  private componentDestroyed$: Subject<void> = new Subject<void>();

  constructor(
    private store: Store<AppState>
  ) { }

  ngOnInit(): void {
    let observer = {
      next: (task: TaskModel) => {
        this.task = { ...task };
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

  onChangeDelivery(toAddress: boolean) {
    this.task.isDeliveryToAddress = toAddress;
  }

  onSaveTask() {
    const task = { ...this.task };
    this.store.dispatch(CartActions.updateCartForm({ task }));
  }
}
