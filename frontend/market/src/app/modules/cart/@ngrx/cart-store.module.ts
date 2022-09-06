import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// @ngrx
import {StoreModule} from "@ngrx/store";
import { EffectsModule } from '@ngrx/effects';

import {cartReducer} from "./cart.reducer";
import { CartEffects } from './cart.effects';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    StoreModule.forFeature('cart', cartReducer),
    EffectsModule.forFeature([CartEffects])
  ]
})
export class CartStoreModule { }
