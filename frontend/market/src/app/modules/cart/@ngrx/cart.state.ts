import {ProductModel} from "../../../model/product";
import {DestinationModel} from "../models/destination.model";

export interface CartState {
  data: ReadonlyArray<ProductModel>;
  destination: Readonly<DestinationModel>;
  isDestinationSubmitted: Readonly<boolean>;
  error: Readonly<Error | string> | null
}

export const initialCartState: CartState = {
  data: [],
  destination: new DestinationModel(),
  isDestinationSubmitted: false,
  error: null
};
