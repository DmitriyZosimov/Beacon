import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ShopComponent} from "./shop.component";
import {TasksListComponent} from "./components/tasks/tasks-list/tasks-list.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: '1',
    pathMatch: 'full'
  },
  {
    path: ':id',
    component: ShopComponent
  },
  {
    path: ':id/tasks',
    component: TasksListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopRoutingModule {
}
