import {ProductModel} from "../../../model/product";
import {CartFormModel} from "../models/cart-form.model";

export interface CartState {
  products: ReadonlyArray<ProductModel>;
  cartForm: CartFormModel;
}

export const initialCartState: CartState = {
  products: [],
  cartForm: new CartFormModel()
};
