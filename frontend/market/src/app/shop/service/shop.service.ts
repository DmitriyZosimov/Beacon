import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
//rxjs
import {Observable} from "rxjs";
import {catchError, map} from "rxjs/operators";

import {ShopModel} from "../../model/shop";
import {ErrorHandlerService} from "../../core/services";
import {ShopAPI} from "../shop.config";

@Injectable({
  providedIn: 'any'
})
export class ShopService {

  constructor(private httpClient: HttpClient,
              private errorHandler: ErrorHandlerService,
              @Inject(ShopAPI) private shopServer: string) {
  }

  public getShopById(id: string): Observable<HttpResponse<ShopModel>> {
    console.log(`${this.shopServer}${id}`);
    return this.httpClient.get(`${this.shopServer}${id}`, {
      responseType: 'json',
      observe: "response"
    })
      .pipe(
        map(response => response || null),
        catchError((err) => this.errorHandler.handleError(err))
      );
  }

}
