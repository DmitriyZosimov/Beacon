import { createAction, props } from '@ngrx/store';

export const getProducts = createAction(
  '[Product List Page] GET_PRODUCTS'
);

export const getProductsSuccess = createAction(
  '[Product List Page] GET_PRODUCTS_SUCCESS',
  props<{ data: any }>()
);

export const getProductsFailure = createAction(
  '[Product List Page] GET_PRODUCTS_FAILURE',
  props<{ error: any }>()
);

export const addProduct = createAction(
  '[Product (Mobile) Page] ADD_PRODUCT'
);

export const addProductSuccess = createAction(
  '[Product (Mobile) Page] ADD_PRODUCT_SUCCESS',
  props<{ data: any }>()
);

export const addProductFailure = createAction(
  '[Product (Mobile) Page] ADD_PRODUCT_FAILURE',
  props<{ error: any }>()
);

export const updateProduct = createAction(
  '[Product List Page] UPDATE_PRODUCT'
);

export const updateProductSuccess = createAction(
  '[Product List Page] UPDATE_PRODUCT_SUCCESS',
  props<{ data: any }>()
);

export const updateProductFailure = createAction(
  '[Product List Page] UPDATE_PRODUCT_FAILURE',
  props<{ error: any }>()
);

export const deleteProduct = createAction(
  '[Product List Page] DELETE_PRODUCT'
);

export const deleteProductSuccess = createAction(
  '[Product List Page] DELETE_PRODUCT_SUCCESS',
  props<{ data: any }>()
);

export const deleteProductFailure = createAction(
  '[Product List Page] DELETE_PRODUCT_FAILURE',
  props<{ error: any }>()
);
