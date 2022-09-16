import {ProductModel} from "../../../model/product";
import {TaskModel} from "../../../model/task";

export interface CartState {
  data: ReadonlyArray<ProductModel>;
  task: Readonly<TaskModel>;
  isTaskSubmitted: Readonly<boolean>;
  error: Readonly<Error | string> | null
}

export const initialCartState: CartState = {
  data: [],
  task: new TaskModel(),
  isTaskSubmitted: false,
  error: null
};
