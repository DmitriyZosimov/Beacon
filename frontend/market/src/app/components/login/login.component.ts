import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../service/auth/authentication.service";

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
    let i = window.location.href.indexOf('code');
    if (!this.isLoggedIn && i != -1) {
      this.service.retrieveToken(window.location.href.substring(i + 5));
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
