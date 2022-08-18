import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {MobileComponent} from "./mobile.component";
import {ProductComponent} from "./components/product/product.component";
import {AddingComponent} from "./components/adding/adding.component";

const routes: Routes = [
  {
    path: ':brand/:model',
    component: ProductComponent
  },
  {
    path: 'add',
    component: AddingComponent
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
export class MobileRoutingModule { }
