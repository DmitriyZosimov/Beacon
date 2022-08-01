import {ErrorHandler, Injectable} from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import {NEVER, Observable, throwError} from "rxjs";
import {UnauthorizedErrorHandlerService} from "./unauthorized-error-handler.service";

@Injectable()
export class ErrorHandlerService implements ErrorHandler {

  constructor(private unauthorizedErrorHandler: UnauthorizedErrorHandlerService) {
  }

  public handleError(err: HttpErrorResponse): Observable<never> {
    let errorMessage: string;
    if (err.error instanceof Error) {
      errorMessage = `An error occurred: ${err.error.message}`;
    } else if (err.status === 401) {
      this.unauthorizedErrorHandler.handleError(err);
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
