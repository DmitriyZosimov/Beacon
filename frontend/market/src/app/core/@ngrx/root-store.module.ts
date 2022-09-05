import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// @ngrx
import {StoreModule} from "@ngrx/store";
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

import { CartStoreModule } from '../../modules/cart/@ngrx/cart-store.module';
import {metaReducers} from "./meta-reducers";
import { environment } from '../../../environments/environment';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CartStoreModule,
    StoreModule.forRoot({}, {metaReducers}),
    // Instrumentation must be imported after importing StoreModule (config is optional)
    !environment.production ? StoreDevtoolsModule.instrument() : [],
  ]
})
export class RootStoreModule { }
