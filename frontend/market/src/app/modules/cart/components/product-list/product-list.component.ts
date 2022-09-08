import {Component, OnInit} from '@angular/core';

import {Observable} from "rxjs";
//@ngrx
import {select, Store} from "@ngrx/store";
import {AppState} from "../../../../core/@ngrx";
import {
  selectDestination,
  selectIsDestinationSubmitted,
  selectProductsData
} from "../../@ngrx";
import * as CartActions from "../../@ngrx";

import {CartService} from "../../services";
import {ProductModel} from "../../../../model/product";
import {DestinationModel} from "../../../../model/destination";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products$!: Observable<ReadonlyArray<ProductModel>>;
  destination!: Observable<Readonly<DestinationModel>>;
  isDestinationSubmitted$!: Observable<Readonly<boolean>>;

  constructor(
    private cartService: CartService,
    private cartStore: Store<AppState>
  ) { }

  ngOnInit(): void {
    this.products$ = this.cartStore.pipe(select(selectProductsData));
    this.destination = this.cartStore.pipe(select(selectDestination));
    this.isDestinationSubmitted$ = this.cartStore.pipe(select(selectIsDestinationSubmitted));
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
    let destination;
    this.destination.subscribe(form => destination = {...form});
    let products;
    this.products$.subscribe(prod => products = [...prod]);
    if (destination && products) {
      this.cartStore.dispatch(CartActions.saveOrder({destination, products}));
    }
  }
}
