import {ErrorHandler, Injectable} from '@angular/core';
import {Router} from "@angular/router";

import {AuthenticationService} from "../";

@Injectable()
export class UnauthorizedErrorHandlerService implements ErrorHandler {

  constructor(private authenticationService: AuthenticationService,
              private router: Router) {
  }

  handleError = (error: any) => {
    if (this.authenticationService.checkCredentials()) {
      this.authenticationService.refreshToken()
        .subscribe(data => {
            this.authenticationService.saveToken(data);
            window.location.reload();
          },
          err => alert('Invalid Refresh token'));
    } else {
      this.router.navigate(['error/unauthorized'])
    }
  }
}
