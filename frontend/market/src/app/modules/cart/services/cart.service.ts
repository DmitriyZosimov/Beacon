import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http"

import {Observable} from "rxjs";
import {map} from "rxjs/operators";

import {ProductModel} from "../../../model/product";
import {MobileAPI} from "../../../catalog/mobile/mobile.config";
import {ImageAdapter} from "../../../core/adapter";
import {OrderModel, TaskModel} from "../../../model/task";

@Injectable()
export class CartService {

  constructor(
    private imageAdapter: ImageAdapter,
    private httpClient: HttpClient,
    @Inject(MobileAPI) private catalogServer: string,
  ) { }

  /* Http methods */
  saveOrder(t: TaskModel, products: ProductModel[]): Observable<number> {
    let headers = new HttpHeaders({
      'Content-type': 'application/json; charset=utf-8'
    });
    let task = { ...t };
    task.orders = this.prepareOrders(products);
    console.log(JSON.stringify(task));
    return this.httpClient.post(`${this.catalogServer}/cart/`, task, {
      headers: headers,
      observe: 'response'
    }).pipe(
      map(response => response.status)
    );
  }

  /* Auxiliary methods */
  adaptImage(image: string) {
    return this.imageAdapter.adapt(image);
  }

  private prepareOrders(products: Array<ProductModel>): Array<OrderModel> {
    let orders = new Array<OrderModel>();
    products.forEach(product => {
      orders.push(new OrderModel(undefined, product.productId, product.shopId, product.price, product.count));
    });
    return orders;
  }

}
