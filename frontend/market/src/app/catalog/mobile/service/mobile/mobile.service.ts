import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Router} from "@angular/router";

//rxjs
import {EMPTY, Observable, of} from "rxjs";
import {catchError, map, switchMap} from "rxjs/operators";

import {Cookie} from 'ng2-cookies';

import {MobileFullModel, MobileModel} from "../../../../model/mobile";
import {DomainCutterPipe} from "../../../../core/pipes";
import {AuthenticationService, ErrorHandlerService} from "../../../../core/services";
import {MobileAPI} from "../../mobile.config";
import {ShopModel} from "../../../../model/shop";
import {ShopAdapter} from "../../../../core/adapter";

@Injectable({
  providedIn: 'any'
})
export class MobileService {

  constructor(protected httpClient: HttpClient,
              private router: Router,
              private errorHandler: ErrorHandlerService,
              private authService: AuthenticationService,
              private domainCutterPipe: DomainCutterPipe,
              private shopAdapter: ShopAdapter,
              @Inject(MobileAPI) private catalogServer: string) {
  }

  public getMobiles(): Observable<HttpResponse<Array<MobileModel>>> {
    return this.httpClient.get<Array<MobileModel>>(`${this.catalogServer}/mobile/`, {
      observe: "response"
    })
      .pipe(
        map(response => response || []),
        catchError((err) => this.errorHandler.handleError(err))
      );
  }

  public getMobileFull(brand: any, model: any): Observable<MobileFullModel> {
    return this.httpClient.get<MobileFullModel>(`${this.catalogServer}/mobile/${brand}/${model}`, {
      responseType: 'json',
      observe: 'response'
    })
      .pipe(
        switchMap(response => {
          let mobile = response?.body;
          if (mobile != null) {
            mobile.offers = this.convertOffersToMap(response?.body?.offers);
          }
          return mobile ? of(mobile) : EMPTY;
        }),
        catchError((err) => this.errorHandler.handleError(err))
      );
  }

  private convertOffersToMap(offers: any) {
    let finalOffers = new Map<ShopModel, number>();
    offers.forEach((value: any) => {
      finalOffers.set(this.shopAdapter.adapt(value.key), value.value);
    });
    return finalOffers;
  }

  public createMobile(mobileFull: MobileFullModel) {
    this.authService.refreshToken()
      .subscribe(success =>{
        this.authService.saveToken(success);
        let headers = new HttpHeaders({
          'Content-type': 'application/json; charset=utf-8',
          'Authorization': 'Bearer ' + Cookie.get('access_token')
        });
        this.httpClient.post<number>(`${this.catalogServer}/mobile/`, mobileFull, {
          headers: headers,
          observe: "response"
        })
          .subscribe(
          (resp) => {
            this.router.navigate([this.domainCutterPipe.transform(resp.headers.get("Location"))]);
          },
          (fail: HttpErrorResponse) => {
            this.errorHandler.handleError(fail);
          }
        )
      },
        error => this.errorHandler.handleError(error));
  }
}
