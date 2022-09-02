import {CartFormModel} from "./cart-form.model";
import {ProductModel} from "../../../model/product";

export class OrderModel {

  constructor(
    public cartForm: CartFormModel,
    public products: Array<ProductModel>
  ) {}
}
