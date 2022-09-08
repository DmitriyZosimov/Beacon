import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http"

import {Observable, of} from "rxjs";
import {map} from "rxjs/operators";

import {ProductModel} from "../../../model/product";
import {DestinationModel} from "../../../model/destination";
import {MobileAPI} from "../../../catalog/mobile/mobile.config";
import {OrderModel} from "../models/order.model";
import {ImageAdapter} from "../../../core/adapter";

@Injectable()
export class CartService {

  constructor(
    private imageAdapter: ImageAdapter,
    private httpClient: HttpClient,
    @Inject(MobileAPI) private catalogServer: string,
  ) { }

  /* Http methods */
  saveOrder(cartForm: DestinationModel, products: ProductModel[]): Observable<number> {
    let headers = new HttpHeaders({
      'Content-type': 'application/json; charset=utf-8'
    });
    let order = new OrderModel(cartForm, this.reduceProduct(products));
    console.log(order);
    return this.httpClient.post(`${this.catalogServer}/cart/`, order, {
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
    let convertedProducts: Array<ProductModel> = [];
    products.forEach(element => {
      const product = { ...element};
        delete product?.price;
        delete product?.shopImage;
        delete product?.productImage;
        delete product?.name;
        delete product?.shopName;
        delete product?.description;
        convertedProducts.push(product!);
      }
    );
    return convertedProducts;
  }

}
