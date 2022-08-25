import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {MobileComponent} from "./mobile.component";
import {ProductComponent} from "./components/product";
import {AddingComponent} from "./components/adding";

const routes: Routes = [
  {
    path: ':brand/:model',
    component: ProductComponent
  },
  {
    path: 'add',
    component: AddingComponent,
    data: { title: 'Adding a new mobile'}
  },
  {
    path: '',
    component: MobileComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MobileRoutingModule {
  static components = [AddingComponent, MobileComponent, ProductComponent]
}
