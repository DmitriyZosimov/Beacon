import {Component, OnInit} from '@angular/core';

import {Observable} from "rxjs";
//@ngrx
import {select, Store} from "@ngrx/store";
import {AppState} from "../../../../core/@ngrx";
import {CartState} from "../../@ngrx";
import * as CartActions from "../../@ngrx";

import {CartService} from "../../services";
import {ProductModel} from "../../../../model/product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products$!: Observable<CartState>;

  constructor(
    private cartService: CartService,
    private cartStore: Store<AppState>
  ) { }

  ngOnInit(): void {
    this.products$ = this.cartStore.pipe(select('cart'));
  }

  onDeleteProduct(product: ProductModel) {
    this.cartStore.dispatch(CartActions.deleteProduct({ product }));
  }

  onUpdateProduct(product: ProductModel) {
    this.cartStore.dispatch(CartActions.updateProduct({ product }));
  }

  get finalBill() {
    let bill = 0;
    this.products$.subscribe(products => products.data.forEach(product => bill += product.price! * product.count));
    return bill;
  }

  onBuy() {
    let cartForm;
    let products;
    this.products$.subscribe(state => {
      cartForm = { ...state.cartForm};
      products = [...state.data];
    });
    if (cartForm && products) {
      this.cartStore.dispatch(CartActions.saveOrder({cartForm, products}));
    }
  }
}
