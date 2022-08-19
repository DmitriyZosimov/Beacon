import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ForbiddenErrorComponent, PageNotFoundComponent, UnauthorizedErrorComponent} from "./components";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/mobile',
    pathMatch: 'full'
  },
  {
    path: 'mobile',
    loadChildren: () => import('./catalog/mobile/mobile.module').then(m => m.MobileModule),
    data: {
      preload: true,
      title: 'Mobile'
    },
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
      },
      {
        path: 'forbidden',
        component: ForbiddenErrorComponent
      },
      {
        path: 'not-found',
        component: PageNotFoundComponent
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
export class AppRoutingModule {
}
