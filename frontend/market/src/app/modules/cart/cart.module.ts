import {ModuleWithProviders, NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartComponent } from './cart.component';
import {CartRoutingModule} from "./cart-routing.module";
import {FormsModule} from "@angular/forms";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { ProductListComponent } from './components/product-list/product-list.component';
import {CartService} from "./services";
import { ProductComponent } from './components/product/product.component';
import { CartFromComponent } from './components/cart-from/cart-from.component';
import { DestinationComponent } from './components/destination/destination.component';

@NgModule({
  declarations: [
    CartComponent,
    ProductListComponent,
    ProductComponent,
    CartFromComponent,
    DestinationComponent
  ],
  imports: [
    CommonModule,
    CartRoutingModule,
    FormsModule,
    NgbModule
  ]
})
export class CartModule {
  static forRoot(): ModuleWithProviders<CartModule> {
    return {
      ngModule: CartModule,
      providers: [CartService]
    };
  }
}
