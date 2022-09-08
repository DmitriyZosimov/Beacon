import {DestinationModel} from "../../model/destination/destination.model";
import {ProductModel} from "./product.model";

export class TaskModel {
  constructor(
    public taskId: number,
    public destination: DestinationModel,
    public products: Array<ProductModel>,
    public isDone: boolean = false
  ) {}
}
