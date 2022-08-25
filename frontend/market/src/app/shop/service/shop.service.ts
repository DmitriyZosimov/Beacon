import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
//rxjs
import {Observable} from "rxjs";
import {catchError, map} from "rxjs/operators";

import {environment} from "../../../environments/environment";

import {ShopModel} from "../../model/shop";
import {ErrorHandlerService} from "../../core/services";

@Injectable({
  providedIn: 'any'
})
export class ShopService {

  private shopServer = environment.shopServer;

  constructor(private httpClient: HttpClient,
              private errorHandler: ErrorHandlerService) {
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
