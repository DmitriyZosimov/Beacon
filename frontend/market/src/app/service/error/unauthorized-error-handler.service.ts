import {ErrorHandler, Injectable} from '@angular/core';
import {AuthenticationService} from "../auth/authentication.service";
import {Router} from "@angular/router";

@Injectable()
export class UnauthorizedErrorHandlerService implements ErrorHandler {

  constructor(private authenticationService: AuthenticationService,
              private router: Router) {}

  handleError = (error: any) => {
    if (this.authenticationService.checkCredentials()) {
      this.authenticationService.refreshToken();
    } else {
      this.router.navigate(['error/unauthorized'])
    }
  }
}
