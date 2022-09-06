import { Action, createReducer, on } from '@ngrx/store';
import {CartState, initialCartState} from "./cart.state";
import * as CartActions from './cart.actions';

export const reducer = createReducer(
  initialCartState,
  on(CartActions.addProduct, state => {
    return {...state};
  }),
  on(CartActions.updateProduct, state => {
    return {...state};
  }),
  on(CartActions.deleteProduct, state => {
    return {...state};
  }),
  on(CartActions.updateCartForm, (state, { cartForm }) => {
    return {
      ...state,
      cartForm,
      isCartFormSubmitted: true
    };
  })

);

export function cartReducer(state: CartState | undefined, action: Action) {
  return reducer(state, action);
}

