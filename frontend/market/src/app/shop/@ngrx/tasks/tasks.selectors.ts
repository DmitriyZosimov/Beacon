import {createFeatureSelector, createSelector} from "@ngrx/store";
import {TasksState} from "./tasks.state";

const selectTasks = (state: TasksState) => state.tasks;
const selectLoading = (state: TasksState) => state.loading;
const selectLoaded = (state: TasksState) => state.loaded;
const selectError = (state: TasksState) => state.error;

export const selectTasksState = createFeatureSelector<TasksState>('tasks');

export const selectTasksData = createSelector(
  selectTasksState, selectTasks
);

export const selectTasksLoaded = createSelector(
  selectTasksState, selectLoaded
);

export const selectTasksLoading = createSelector(
  selectTasksState, selectLoading
);

export const selectTasksError = createSelector(
  selectTasksState, selectError
);
