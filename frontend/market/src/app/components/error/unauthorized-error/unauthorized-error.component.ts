import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../../service/auth/authentication.service";

@Component({
  selector: 'app-unauthorized-error',
  templateUrl: './unauthorized-error.component.html',
  styleUrls: ['./unauthorized-error.component.css']
})
export class UnauthorizedErrorComponent implements OnInit {

  image!: string;

  showing!: boolean;

  constructor(private authService: AuthenticationService) { }

  ngOnInit(): void {
    this.showing = false;
    if (window.screen.width <= 576) {
      this.image = '/assets/img/error_401_small.png'
    } else {
      this.image = '/assets/img/error_401.png'
    }
    setTimeout(() => this.showing = true, 2000);
  }

  onLogin() {
    this.authService.login();
  }
}
