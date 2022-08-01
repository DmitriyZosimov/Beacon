import {ErrorHandler, Injectable} from '@angular/core';
import {AuthenticationService} from "../auth/authentication.service";

@Injectable()
export class UnauthorizedErrorHandlerService implements ErrorHandler {

  constructor(private authenticationService: AuthenticationService) {}

  handleError = (error: any) => {
    if (this.authenticationService.checkCredentials()) {
      this.authenticationService.refreshToken();
    } else {
      this.authenticationService.login();
    }
  }
}
