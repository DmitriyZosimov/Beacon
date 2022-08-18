import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {
  CartComponent,
  ForbiddenErrorComponent,
  InformationComponent,
  LoginComponent,
  LogoComponent,
  NavigationComponent,
  PageNotFoundComponent,
  SearchComponent,
  UnauthorizedErrorComponent
} from './components';
import {MobileModule} from './catalog/mobile/mobile.module';
import {AuthenticationService, ErrorHandlerService, UnauthorizedErrorHandlerService} from "./service";
import {ShopModule} from "./shop/shop.module";

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    InformationComponent,
    LogoComponent,
    SearchComponent,
    LoginComponent,
    CartComponent,
    PageNotFoundComponent,
    UnauthorizedErrorComponent,
    ForbiddenErrorComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    HttpClientModule,
    MobileModule,
    ShopModule,
    AppRoutingModule,
  ],
  providers: [
    AuthenticationService,
    ErrorHandlerService,
    UnauthorizedErrorHandlerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
