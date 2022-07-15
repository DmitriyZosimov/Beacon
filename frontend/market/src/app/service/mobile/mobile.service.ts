import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams, HttpResponse} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {MobileDto, MobileDtoFull} from "../../model/mobile/mobile-dto";
import {catchError, map, tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class MobileService {

  private catalogServer = environment.catalogServer;

  constructor(protected httpClient: HttpClient) {
  }

  public getMobileDtos(): Observable<HttpResponse<Array<MobileDto>>> {
    return this.httpClient.get<Array<MobileDto>>(`${this.catalogServer}/mobile/`, {observe: "response"})
      .pipe(
        map(response => response || []),
        tap(response => console.log('SERVICE: ' + JSON.stringify(response))),
        catchError(this.handleError)
      );
  }

  public getMobileDtoFull(url: string): Observable<HttpResponse<MobileDtoFull>> {
    // const params = new HttpParams({
    //   fromObject: {
    //     full: true
    //   }
    // });
    return this.httpClient.get<MobileDtoFull>(`${this.catalogServer}${url}`, {
      responseType: 'json',
      observe: 'response'
    })
      .pipe(
        map(response => response || null),
        tap(response => console.log(JSON.stringify(response))),
        catchError(this.handleError)
      );
  }

  public createMobile(mobileDtoFull: MobileDtoFull): Observable<number> {
    return this.httpClient.post<number>(`${this.catalogServer}/mobile/`, mobileDtoFull);
  }

  private handleError(err: HttpErrorResponse): Observable<never> {
    let errorMessage: string;
    if (err.error instanceof Error) {
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {
      errorMessage = `Backend returned code ${err.status}, body was: ${err.error}`;
    }
    console.error(errorMessage);
    return Observable.throw(errorMessage);
  }
}
