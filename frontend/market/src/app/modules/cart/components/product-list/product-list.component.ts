import {Component, OnInit} from '@angular/core';

import {Observable} from "rxjs";
//@ngrx
import {select, Store} from "@ngrx/store";
import {AppState} from "../../../../core/@ngrx";
import {selectCartForm, selectIsCartFormSubmitted, selectProductsData} from "../../@ngrx";
import * as CartActions from "../../@ngrx";

import {CartService} from "../../services";
import {ProductModel} from "../../../../model/product";
import {CartFormModel} from "../../models/cart-form.model";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products$!: Observable<ReadonlyArray<ProductModel>>;
  cartForm$!: Observable<Readonly<CartFormModel>>;
  isCartFormSubmitted$!: Observable<Readonly<boolean>>;

  constructor(
    private cartService: CartService,
    private cartStore: Store<AppState>
  ) { }

  ngOnInit(): void {
    this.products$ = this.cartStore.pipe(select(selectProductsData));
    this.cartForm$ = this.cartStore.pipe(select(selectCartForm));
    this.isCartFormSubmitted$ = this.cartStore.pipe(select(selectIsCartFormSubmitted));
  }

  onDeleteProduct(product: ProductModel) {
    this.cartStore.dispatch(CartActions.deleteProduct({ product }));
  }

  onUpdateProduct(product: ProductModel) {
    this.cartStore.dispatch(CartActions.updateProduct({ product }));
  }

  get finalBill() {
    let bill = 0;
    this.products$.subscribe(products => products.forEach(product => bill += product.price! * product.count));
    return bill;
  }

  onBuy() {
    let cartForm;
    this.cartForm$.subscribe(form => cartForm = {...form});
    let products;
    this.products$.subscribe(prod => products = [...prod]);
    if (cartForm && products) {
      this.cartStore.dispatch(CartActions.saveOrder({cartForm, products}));
    }
  }
}
