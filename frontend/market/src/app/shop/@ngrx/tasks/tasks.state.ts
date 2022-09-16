import {TaskModel} from "../../../model/task";

export interface TasksState {
  tasks: ReadonlyArray<TaskModel>;
  loading: Readonly<boolean>;
  loaded: Readonly<boolean>;
  error: Error | string | null;
}

export const initialTasksState: TasksState = {
  tasks: [],
  loading: false,
  loaded: false,
  error: null
};
