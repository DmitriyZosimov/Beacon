import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StoreModule} from "@ngrx/store";
import { CartStoreModule } from '../../modules/cart/@ngrx/cart-store.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    StoreModule.forRoot({}, {}),
    CartStoreModule,
  ]
})
export class RootStoreModule { }
