import {Component, OnDestroy, OnInit} from '@angular/core';
// @ngrx
import {select, Store} from "@ngrx/store";

// @rxjs
import {Subject} from "rxjs";
import {takeUntil} from "rxjs/operators";

import {CartFormModel} from "../../models/cart-form.model";
import {AppState} from "../../../../core/@ngrx";
import {selectCartForm} from "../../@ngrx";
import * as CartActions from '../../@ngrx/cart.actions';

@Component({
  selector: 'app-cart-from',
  templateUrl: './cart-from.component.html',
  styleUrls: ['./cart-from.component.css']
})
export class CartFromComponent implements OnInit, OnDestroy {

  cartForm!: CartFormModel;

  private componentDestroyed$: Subject<void> = new Subject<void>();

  constructor(
    private store: Store<AppState>
  ) { }

  ngOnInit(): void {
    let observer = {
      next: (cartForm: CartFormModel) => {
        this.cartForm = { ...cartForm };
      },
      error(err: Error | string) {
        console.log(err);
      },
      complete() {
        console.log('Stream is completed')
      }
    };

    this.store.pipe(
      select(selectCartForm),
      takeUntil(this.componentDestroyed$)
    ).subscribe(observer);
  }

  ngOnDestroy(): void {
    this.componentDestroyed$.next();
    this.componentDestroyed$.complete();
  }

  onChangeDelivery(toAddress: boolean) {
    this.cartForm.isDeliveryToAddress = toAddress;
  }

  onSaveCartForm() {
    const cartForm = { ...this.cartForm };
    this.store.dispatch(CartActions.updateCartForm({ cartForm }));
  }
}
