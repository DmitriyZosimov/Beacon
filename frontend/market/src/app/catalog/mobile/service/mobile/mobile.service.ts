import {Inject, Injectable, Optional} from '@angular/core';
import {KeyValue} from "@angular/common";
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Router} from "@angular/router";

// @ngrx
import {Store} from "@ngrx/store";

//rxjs
import {EMPTY, Observable, of} from "rxjs";
import {catchError, map, switchMap} from "rxjs/operators";

import {Cookie} from 'ng2-cookies';

import {MobileFullModel, MobileModel} from "../../../../model/mobile";
import {DomainCutterPipe} from "../../../../core/pipes";
import {AuthenticationService, ErrorHandlerService} from "../../../../core/services";
import {MobileAPI} from "../../mobile.config";
import {ShopModel} from "../../../../model/shop";
import {ImageAdapter, ShopAdapter} from "../../../../core/adapter";
import {ProductModel} from "../../../../model/product";
import {SafeUrl} from "@angular/platform-browser";
import {AppState} from "../../../../core/@ngrx";
import {addProduct} from "../../../../modules/cart/@ngrx";

@Injectable({
  providedIn: 'any'
})
export class MobileService {

  constructor(protected httpClient: HttpClient,
              private router: Router,
              private errorHandler: ErrorHandlerService,
              private authService: AuthenticationService,
              private domainCutterPipe: DomainCutterPipe,
              private imageAdapter: ImageAdapter,
              private shopAdapter: ShopAdapter,
              @Inject(MobileAPI) private catalogServer: string,
              private store: Store<AppState>) {
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

  addToCart(mobile: MobileFullModel, offer: KeyValue<ShopModel, number>) {
    let product = new ProductModel(mobile.mobileId!, offer.key.shopId!, this.getMobileTitle(mobile), offer.value,
      offer.key.name!, mobile.mainImage?.image!, offer.key.logo?.logo!, this.getMobileDescription(mobile));
    console.log('product ' + product);
    this.store.dispatch(addProduct({ product }));
  }

  getMobileTitle(mobileFull: MobileFullModel): string {
    return `${mobileFull.brand} ${mobileFull.model} ${mobileFull.ram}/${mobileFull.storageCapacity} (${mobileFull.color})`;
  }
  
  getMobileDescription(mobileFull: MobileFullModel): string {
    let shortDescription = '';
    if (mobileFull !== undefined && mobileFull !== null) {
      if (mobileFull.os !== null) {
        shortDescription = shortDescription.concat(mobileFull.os + ', ');
      }
      if (mobileFull.screenSize !== null) {
        shortDescription = shortDescription.concat('screen ' + mobileFull.screenSize + '\", ');
      }
      if (mobileFull.displayTechnology !== null) {
        shortDescription = shortDescription.concat(mobileFull.displayTechnology + ', ');
      }
      if (mobileFull.displayResolution !== null) {
        shortDescription = shortDescription.concat('(' + mobileFull.displayResolution + '), ');
      }
      if (mobileFull.chipsetModel !== null) {
        shortDescription = shortDescription.concat(mobileFull.chipsetModel + ', ');
      }
      if (mobileFull.ram !== null) {
        shortDescription = shortDescription.concat('RAM ' + mobileFull.ram + ' GB, ');
      }
      if (mobileFull.storageCapacity !== null) {
        shortDescription = shortDescription.concat('storage capacity ' + mobileFull.storageCapacity + ' GB, ');
      }
      if (mobileFull.cameraResolution !== null) {
        shortDescription = shortDescription.concat('camera ' + mobileFull.cameraResolution + ' MP, ');
      }
      if (mobileFull.battery !== null) {
        shortDescription = shortDescription.concat('battery ' + mobileFull.battery + ' mAh, ');
      }
      if (mobileFull.simCardSlot !== null) {
        shortDescription = shortDescription.concat(mobileFull.simCardSlot + ' SIM');
      }
      shortDescription = shortDescription.trim();
      if (shortDescription.endsWith(',')) {
        shortDescription = shortDescription.slice(0, -1)
      }
    }
    return shortDescription;
  }

  getImage(image: string): SafeUrl {
    return this.imageAdapter.adapt(image);
  }
}
