import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";
import {UnauthorizedErrorComponent} from "./components/error/unauthorized-error/unauthorized-error.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/mobile',
    pathMatch: 'full'
  },
  {
    path: 'mobile',
    loadChildren: () => import('./catalog/mobile/mobile.module').then(m => m.MobileModule)
  },
  {
    path: 'shop',
    loadChildren: () => import('./shop/shop.module').then(m => m.ShopModule)
  },
  {
    path: 'error',
    children: [
      {
        path: 'unauthorized',
        component: UnauthorizedErrorComponent
      }
    ]
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
