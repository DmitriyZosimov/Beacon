import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http"

import {EMPTY, Observable, of} from "rxjs";
import {catchError, map} from "rxjs/operators";

import {ProductModel} from "../../../model/product";
import {CartFormModel} from "../models/cart-form.model";
import {MobileAPI} from "../../../catalog/mobile/mobile.config";
import {OrderModel} from "../models/order.model";
import {ImageAdapter} from "../../../core/adapter";

const productList: Array<ProductModel> = [];
const productListObservable: Observable<Array<ProductModel>> = of(productList);

@Injectable()
export class CartService {

  products$: Observable<Array<ProductModel>> = productListObservable;

  constructor(
    private imageAdapter: ImageAdapter,
    private httpClient: HttpClient,
    @Inject(MobileAPI) private catalogServer: string,
  ) { }

  /* Main methods */
  getProducts(): Observable<Array<ProductModel>> {
    return this.products$
      .pipe(
        catchError(err => {
          console.log(err);
          return EMPTY;
        })
      );
  }

  addProduct(product: ProductModel) {
    productList.push(product);
  }

  updateProduct(product: ProductModel) {
    const index = productList.findIndex(prod => prod === product);
    if (index > -1) {
      productList.splice(index, 1, product);
    }
  }

  deleteProduct(product: ProductModel) {
    const index = productList.findIndex(prod => prod === product);
    if (index > -1) {
      productList.splice(index, 1);
    }
  }

  /* Http methods */
  saveOrder(cartForm: CartFormModel): Observable<number> {
    let headers = new HttpHeaders({
      'Content-type': 'application/json; charset=utf-8'
    });
    let order = new OrderModel(cartForm, this.reduceProduct(productList));
    console.log(order);
    return this.httpClient.post(`${this.catalogServer}/cart/`, order,{
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

  private reduceProduct(products: Array<ProductModel>): Array<ProductModel> {
    let convertedProducts = [];
    while (products.length > 0) {
      let product = products.pop();
      delete product?.price;
      delete product?.shopImage;
      delete product?.productImage;
      delete product?.name;
      delete product?.shopName;
      delete product?.description;
      convertedProducts.push(product!);
      console.log(products.length);
    }
    return convertedProducts;
  }

}
