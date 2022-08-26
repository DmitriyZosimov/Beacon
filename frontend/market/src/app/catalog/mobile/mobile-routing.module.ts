import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { MetaDefinition } from '@angular/platform-browser';

import {MobileComponent} from "./mobile.component";
import {ProductComponent} from "./components/product";
import {AddingComponent} from "./components/adding";
import {ProductResolverGuard} from "./guards";

const metaTags: Array<MetaDefinition> = [
  {
    name: 'description',
    content: 'Buy a new phone in the Beacon of catalog'
  },
  {
    name: 'keywords',
    content: 'Mobile, Phone, New, Buy'
  }
];

const routes: Routes = [
  {
    path: ':brand/:model',
    component: ProductComponent,
    resolve: {
      mobile: ProductResolverGuard
    }
  },
  {
    path: 'add',
    component: AddingComponent,
    data: { title: 'Adding a new mobile'}
  },
  {
    path: '',
    component: MobileComponent,
    data: {
      meta: metaTags
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MobileRoutingModule {
  static components = [AddingComponent, MobileComponent, ProductComponent]
}
