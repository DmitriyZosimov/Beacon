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
import { DomainCutterPipe } from './core/pipes';

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
    ForbiddenErrorComponent,
    DomainCutterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    MobileModule,
    ShopModule
  ],
  providers: [
    AuthenticationService,
    ErrorHandlerService,
    UnauthorizedErrorHandlerService,
    DomainCutterPipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
