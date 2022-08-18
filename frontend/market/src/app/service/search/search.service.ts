import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams, HttpResponse} from "@angular/common/http";
//rxjs
import {Observable} from "rxjs";
import {catchError, map, tap} from "rxjs/operators";

import {MobileModel} from "../../model/mobile";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  searchServer = environment.searchServer;

  constructor(protected httpClient: HttpClient) {
  }

  public search(query: string): Observable<HttpResponse<Array<MobileModel>>> {
    const params = new HttpParams({
      fromObject: {
        query: query
      }
    });
    return this.httpClient.get<Array<MobileModel>>(`${this.searchServer}/search`, {
      responseType: 'json',
      observe: 'response',
      params: params
    })
      .pipe(
        map(response => response || null),
        tap(response => console.log(JSON.stringify('SEARCH SERVICE:' + response))),
        catchError(this.handleError)
      );
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
