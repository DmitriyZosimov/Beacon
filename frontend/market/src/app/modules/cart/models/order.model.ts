import {DestinationModel} from "../../../model/destination";
import {ProductModel} from "../../../model/product";

export class OrderModel {

  constructor(
    public destination: DestinationModel,
    public products: Array<ProductModel>
  ) {}
}
