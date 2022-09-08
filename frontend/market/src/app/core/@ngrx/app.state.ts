import {CartState} from "../../modules/cart/@ngrx";
import {TasksState} from "../../shop/@ngrx/tasks";

export interface AppState {
  cart: CartState;
  tasks: TasksState;
}
