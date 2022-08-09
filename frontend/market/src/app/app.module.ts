import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NavigationComponent} from './components/navigation/navigation.component';
import {InformationComponent} from './components/information/information.component';
import {LogoComponent} from './components/logo/logo.component';
import {SearchComponent} from './components/search/search.component';
import {LoginComponent} from './components/login/login.component';
import {CartComponent} from './components/cart/cart.component';
import {MobileModule} from './catalog/mobile/mobile.module';
import {HttpClientModule} from "@angular/common/http";
import {PageNotFoundComponent} from './components/page-not-found/page-not-found.component';
import {AuthenticationService} from "./service/auth/authentication.service";
import {ErrorHandlerService} from "./service/error/error-handler.service";
import {UnauthorizedErrorHandlerService} from "./service/error/unauthorized-error-handler.service";
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
    PageNotFoundComponent
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
    UnauthorizedErrorHandlerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
