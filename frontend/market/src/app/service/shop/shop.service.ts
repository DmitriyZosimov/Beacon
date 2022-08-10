import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ErrorHandlerService} from "../error/error-handler.service";
import {Observable} from "rxjs";
import {Shop} from "../../model/shop/shop";
import {catchError, map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  private shopServer = environment.shopServer;

  constructor(private httpClient: HttpClient,
              private errorHandler: ErrorHandlerService) {
  }

  public getShopById(id: string): Observable<HttpResponse<Shop>> {
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
