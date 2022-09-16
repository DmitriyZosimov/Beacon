import {Component, OnInit} from '@angular/core';

import {Observable} from "rxjs";
//@ngrx
import {select, Store} from "@ngrx/store";
import {AppState} from "../../../../core/@ngrx";
import {
  selectTask,
  selectIsTaskSubmitted,
  selectProductsData
} from "../../@ngrx";
import * as CartActions from "../../@ngrx";

import {CartService} from "../../services";
import {ProductModel} from "../../../../model/product";
import {TaskModel} from "../../../../model/task";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products$!: Observable<ReadonlyArray<ProductModel>>;
  task!: Observable<Readonly<TaskModel>>;
  isTaskSubmitted$!: Observable<Readonly<boolean>>;

  constructor(
    private cartService: CartService,
    private cartStore: Store<AppState>
  ) { }

  ngOnInit(): void {
    this.products$ = this.cartStore.pipe(select(selectProductsData));
    this.task = this.cartStore.pipe(select(selectTask));
    this.isTaskSubmitted$ = this.cartStore.pipe(select(selectIsTaskSubmitted));
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
    let task;
    this.task.subscribe(form => task = {...form});
    let products;
    this.products$.subscribe(prod => products = [...prod]);
    if (task && products) {
      this.cartStore.dispatch(CartActions.saveOrder({task, products}));
    }
  }
}
