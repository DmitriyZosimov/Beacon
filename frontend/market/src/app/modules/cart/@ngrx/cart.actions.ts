import { createAction, props } from '@ngrx/store';
import {ProductModel} from "../../../model/product";
import {TaskModel} from "../../../model/task";

export const addProduct = createAction(
  '[Product (Mobile) Page] ADD_PRODUCT',
  props<{ product: ProductModel }>()
);

export const updateProduct = createAction(
  '[Product List Page] UPDATE_PRODUCT',
  props<{ product: ProductModel }>()
);

export const deleteProduct = createAction(
  '[Product List Page] DELETE_PRODUCT',
  props<{ product: ProductModel }>()
);

// CART FORM
export const updateCartForm = createAction(
  '[Cart Form Page] UPDATE_CART_FORM',
  props<{ task: TaskModel}>()
);

// EFFECT
export const saveOrder = createAction(
  '[Save Order Effect] SAVE_ORDER',
  props<{ task: TaskModel, products: ProductModel[] }>()
);

export const saveOrderSuccess = createAction(
  '[Save Order Effect] SAVE_ORDER_SUCCESS'
);

export const saveOrderFailure = createAction(
  '[Save Order Effect] SAVE_ORDER_Failure',
  props<{ error: Error | string }>()
);
