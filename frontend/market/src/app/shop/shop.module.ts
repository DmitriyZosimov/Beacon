import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopRoutingModule } from './shop-routing.module';
import { ShopComponent } from './shop.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { TasksListComponent } from './components/tasks/tasks-list/tasks-list.component';


@NgModule({
  declarations: [
    ShopComponent,
    TasksListComponent
  ],
  imports: [
    CommonModule,
    ShopRoutingModule,
    NgbModule
  ]
})
export class ShopModule { }
