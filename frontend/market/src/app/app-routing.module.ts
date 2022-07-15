import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";

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
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
