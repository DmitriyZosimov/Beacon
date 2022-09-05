import { Action, createReducer, on } from '@ngrx/store';
import {CartState, initialCartState} from "./cart.state";
import * as CartActions from './cart.actions';

export const reducer = createReducer(
  initialCartState,
  on(CartActions.getProducts, state => {
    return {...state};
  }),
  on(CartActions.addProduct, state => {
    return {...state};
  }),
  on(CartActions.updateProduct, state => {
    return {...state};
  }),
  on(CartActions.deleteProduct, state => {
    return {...state};
  })

);

export function cartReducer(state: CartState | undefined, action: Action) {
  return reducer(state, action);
}

