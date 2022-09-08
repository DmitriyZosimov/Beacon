import {createFeatureSelector, createSelector} from '@ngrx/store';

import { CartState } from './cart.state';

export const selectCartState = createFeatureSelector<CartState>('cart');

export const selectProductsData = createSelector(selectCartState, (state: CartState) => state.data);
export const selectDestination = createSelector(selectCartState, (state: CartState) => state.destination);
export const selectIsDestinationSubmitted = createSelector(selectCartState, (state: CartState) => state.isDestinationSubmitted);
