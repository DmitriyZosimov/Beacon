import {Injectable} from '@angular/core';
import {Router} from "@angular/router";
// @ngrx
import {Actions, createEffect, ofType} from '@ngrx/effects';
import {Action} from "@ngrx/store";
// rxjs
import {Observable, of} from "rxjs";
import {catchError, concatMap, map} from "rxjs/operators";

import {CartService} from "../services";
import * as CartActions from "./cart.actions";

@Injectable()
export class CartEffects {

  constructor(
    private actions$: Actions,
    private cartService: CartService,
    private router: Router
  ) {}

  saveOrder$: Observable<Action> = createEffect(() =>
    this.actions$.pipe(
      ofType(CartActions.saveOrder),
      concatMap(value =>
        this.cartService.saveOrder(value.cartForm, value.products).pipe(
          map(() => {
            this.router.navigate(['/success']);
            return CartActions.saveOrderSuccess();
          }),
          catchError(error => of(CartActions.saveOrderFailure({error})))
        )
      )
    )
  );
}
