import {createFeatureSelector, createSelector} from '@ngrx/store';

import { CartState } from './cart.state';

export const selectCartState = createFeatureSelector<CartState>('cart');

export const selectProductsData = createSelector(selectCartState, (state: CartState) => state.data);
export const selectCartForm = createSelector(selectCartState, (state: CartState) => state.cartForm);
export const selectIsCartFormSubmitted = createSelector(selectCartState, (state: CartState) => state.isCartFormSubmitted);
