import {ProductModel} from "../../../model/product";
import {CartFormModel} from "../models/cart-form.model";

export interface CartState {
  data: ReadonlyArray<ProductModel>;
  cartForm: Readonly<CartFormModel>;
  isCartFormSubmitted: Readonly<boolean>;
  error: Readonly<Error | string> | null
}

export const initialCartState: CartState = {
  data: [],
  cartForm: new CartFormModel(),
  isCartFormSubmitted: false,
  error: null
};
