import {Action, createReducer, on} from "@ngrx/store";
import {initialTasksState, TasksState} from "./tasks.state";
import * as TasksAction from "./tasks.action";

const reducer = createReducer(
  initialTasksState,
  on(TasksAction.getTasks, state => {
    return {
      ...state,
      loading: true
    }
  }),

  on(TasksAction.getTasksSuccess, (state, { tasks }) => {
    return {
      ...state,
      tasks,
      loading:false,
      loaded: true
    }
  }),

  on(TasksAction.getTasksFailure, (state, { error }) => {
    return {
      ...state,
      loading: false,
      loaded: false,
      error
    }
  }),

  on(TasksAction.updateTaskSuccess, (state, { task }) => {
    const tasks = [...state.tasks];
    const index = tasks.findIndex(t => t.taskId && task.taskId);
    tasks[index] = { ...task };
    return {
      ...state,
      tasks
    }
  }),

  on(TasksAction.updateTaskFailure, (state, { error }) => {
    return {
      ...state,
      error
    }
  })
);

export function tasksReducer(state: TasksState | undefined, action: Action) {
  return reducer(state, action);
}
