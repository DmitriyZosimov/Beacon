import { Action, createReducer, on } from '@ngrx/store';
import {CartState, initialCartState} from "./cart.state";
import * as CartActions from './cart.actions';

export const reducer = createReducer(
  initialCartState,
  on(CartActions.addProduct, (state, { product }) => {
    const data = [...state.data, {...product}];
    return {
      ...state,
      data
    }
  }),
  on(CartActions.updateProduct, (state, { product }) => {
    console.log('UPDATE_PRODUCT');
    const data = [...state.data];
    const index = data.findIndex(prod => prod.shopId === product.shopId && prod.productId === product.productId);
    data[index] = { ...product};
    return {
      ...state,
      data
    };
  }),
  on(CartActions.deleteProduct, (state, { product }) => {
    const data = state.data.filter(prod => prod !== product);
    return {
      ...state,
      data
    };
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

