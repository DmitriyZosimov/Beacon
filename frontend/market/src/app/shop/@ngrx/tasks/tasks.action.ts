import {createAction, props} from "@ngrx/store";
import {TaskModel} from "../../models/task.model";

export const getTasks = createAction(
  '[Get Tasks Page] GET_TASKS'
);

export const getTasksSuccess = createAction(
  '[Get Tasks Effect] GET_TASKS_SUCCESS',
  props<{ tasks: Array<TaskModel> }>()
);

export const getTasksFailure = createAction(
  '[Get Tasks Effect] GET_TASKS_FAILURE',
  props<{ error: Error | string }>()
);

export const updateTask = createAction(
  '[Complete/Reset Task Page] COMPLETE/RESET_TASK',
  props<{ task: TaskModel }>()
);

export const updateTaskSuccess = createAction(
  '[Complete/Reset Task Effect] COMPLETE/RESET_TASK_SUCCESS',
  props<{ task: TaskModel }>()
);

export const updateTaskFaluire = createAction(
  '[Complete/Reset Task Effect] COMPLETE/RESET_TASK_FAILURE',
  props<{ error: Error | string }>()
);
