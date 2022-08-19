import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Router} from "@angular/router";

//rxjs
import {Observable} from "rxjs";
import {catchError, map} from "rxjs/operators";

import {Cookie} from 'ng2-cookies';

import {environment} from "../../../../../environments/environment";

import {ErrorHandlerService} from "../../../../service";
import {MobileModel, MobileFullModel} from "../../../../model/mobile";

@Injectable({
  providedIn: 'any'
})
export class MobileService {

  private catalogServer = environment.catalogServer;

  constructor(protected httpClient: HttpClient,
              private router: Router,
              private errorHandler: ErrorHandlerService) {
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

  public getMobileFull(url: string): Observable<HttpResponse<MobileFullModel>> {
    return this.httpClient.get<MobileFullModel>(`${this.catalogServer}${url}`, {
      responseType: 'json',
      observe: 'response'
    })
      .pipe(
        map(response => response || null),
        catchError((err) => this.errorHandler.handleError(err))
      );
  }

  public createMobile(mobileFull: MobileFullModel) {
    let headers = new HttpHeaders({
      'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Bearer ' + Cookie.get('access_token')
    });
    this.httpClient.post<number>(`${this.catalogServer}/mobile/`, mobileFull, {
      headers: headers,
      observe: "response"
    }).subscribe(
      (resp) => {
        console.log("Succ: " + resp.status.valueOf());
      },
      (fail: HttpErrorResponse) => {
        this.errorHandler.handleError(fail);
      }
    )

  }
}
