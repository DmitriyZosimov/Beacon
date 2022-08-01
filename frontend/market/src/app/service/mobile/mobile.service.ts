import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {MobileDto, MobileDtoFull} from "../../model/mobile/mobile-dto";
import {catchError, map} from "rxjs/operators";
import {Cookie} from 'ng2-cookies';
import {Router} from "@angular/router";
import {ErrorHandlerService} from "../error/error-handler.service";

@Injectable({
  providedIn: 'root'
})
export class MobileService {

  private catalogServer = environment.catalogServer;

  constructor(protected httpClient: HttpClient,
              private router: Router,
              private errorHandler: ErrorHandlerService) {
  }

  public getMobileDtos(): Observable<HttpResponse<Array<MobileDto>>> {
    return this.httpClient.get<Array<MobileDto>>(`${this.catalogServer}/mobile/`, {
      observe: "response"
    })
      .pipe(
        map(response => response || []),
        catchError((err) => this.errorHandler.handleError(err))
      );
  }

  public getMobileDtoFull(url: string): Observable<HttpResponse<MobileDtoFull>> {
    return this.httpClient.get<MobileDtoFull>(`${this.catalogServer}${url}`, {
      responseType: 'json',
      observe: 'response'
    })
      .pipe(
        map(response => response || null),
        catchError((err) => this.errorHandler.handleError(err))
      );
  }

  public createMobile(mobileDtoFull: MobileDtoFull) {
    let headers = new HttpHeaders({
      'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Bearer ' + Cookie.get('access_token')
    });
    this.httpClient.post<number>(`${this.catalogServer}/mobile/`, mobileDtoFull, {
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
