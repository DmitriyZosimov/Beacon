import {ErrorHandler, Injectable, ViewContainerRef} from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import {NEVER, Observable, throwError} from "rxjs";
import {UnauthorizedErrorHandlerService} from "./unauthorized-error-handler.service";
import {Router} from "@angular/router";

@Injectable()
export class ErrorHandlerService implements ErrorHandler {

  constructor(private unauthorizedErrorHandler: UnauthorizedErrorHandlerService,
              private router:Router) {
  }

  public handleError(err: HttpErrorResponse): Observable<never> {
    let errorMessage: string;
    if (err.error instanceof Error) {
      errorMessage = `An error occurred: ${err.error.message}`;
    } else if (err.status === 401) {
      this.unauthorizedErrorHandler.handleError(err);
    } else if (err.status === 404) {
      this.router.navigate(['404']);
    } else {
      errorMessage = `Backend returned code ${err.status}, body was: ${err.error}`;
    }

    if (errorMessage!) {
      console.error(errorMessage);
      return throwError(errorMessage);
    }
    return NEVER;
  }
}
