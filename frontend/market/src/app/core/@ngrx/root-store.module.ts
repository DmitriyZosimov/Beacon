import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StoreModule} from "@ngrx/store";
import { CartStoreModule } from '../../modules/cart/@ngrx/cart-store.module';
import {metaReducers} from "./meta-reducers";



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    StoreModule.forRoot({}, {metaReducers}),
    CartStoreModule,
  ]
})
export class RootStoreModule { }
