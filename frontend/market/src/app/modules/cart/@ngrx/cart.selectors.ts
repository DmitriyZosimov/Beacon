import {createFeatureSelector, createSelector} from '@ngrx/store';

import { CartState } from './cart.state';

export const selectCartState = createFeatureSelector<CartState>('cart');

export const selectProductsData = createSelector(selectCartState, (state: CartState) => state.data);
export const selectTask = createSelector(selectCartState, (state: CartState) => state.task);
export const selectIsTaskSubmitted = createSelector(selectCartState, (state: CartState) => state.isTaskSubmitted);
