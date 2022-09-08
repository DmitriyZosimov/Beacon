import {Component, OnDestroy, OnInit} from '@angular/core';
// @ngrx
import {select, Store} from "@ngrx/store";

// @rxjs
import {Subject} from "rxjs";
import {takeUntil} from "rxjs/operators";

import {DestinationModel} from "../../models/destination.model";
import {AppState} from "../../../../core/@ngrx";
import {selectDestination} from "../../@ngrx";
import * as CartActions from '../../@ngrx/cart.actions';

@Component({
  selector: 'app-cart-from',
  templateUrl: './cart-from.component.html',
  styleUrls: ['./cart-from.component.css']
})
export class CartFromComponent implements OnInit, OnDestroy {

  destination!: DestinationModel;

  private componentDestroyed$: Subject<void> = new Subject<void>();

  constructor(
    private store: Store<AppState>
  ) { }

  ngOnInit(): void {
    let observer = {
      next: (destination: DestinationModel) => {
        this.destination = { ...destination };
      },
      error(err: Error | string) {
        console.log(err);
      },
      complete() {
        console.log('Stream is completed')
      }
    };

    this.store.pipe(
      select(selectDestination),
      takeUntil(this.componentDestroyed$)
    ).subscribe(observer);
  }

  ngOnDestroy(): void {
    this.componentDestroyed$.next();
    this.componentDestroyed$.complete();
  }

  onChangeDelivery(toAddress: boolean) {
    this.destination.isDeliveryToAddress = toAddress;
  }

  onSaveDestination() {
    const destination = { ...this.destination };
    this.store.dispatch(CartActions.updateCartForm({ destination }));
  }
}
