import {Component, OnInit} from '@angular/core';

import {AuthenticationService} from "../../core/services";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public isLoggedIn = false;

  constructor(private service: AuthenticationService) {
  }

  ngOnInit(): void {
    this.isLoggedIn = this.service.checkCredentials();
    let i = window.location.href.includes('code');
    if (!this.isLoggedIn && i) {
      this.service.retrieveToken();
    }
  }

  login() {
    this.service.login();
  }

  logout() {
    this.isLoggedIn = false;
    this.service.logout();
  }

}
