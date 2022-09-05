import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { StoreModule } from '@ngrx/store';

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
import {
  AuthenticationService,
  ErrorHandlerService,
  UnauthorizedErrorHandlerService,
  DomainCutterPipe
} from "./core";

//modules
import {CartModule} from "./modules/cart/cart.module";
import {MobileModule} from './catalog/mobile/mobile.module';
import {ShopModule} from "./shop/shop.module";
import {SpinnerModule} from "./widgets/spinner/spinner.module";

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
    CartModule.forRoot(),
    MobileModule,
    ShopModule,
    SpinnerModule.forRoot(),
    StoreModule.forRoot({}, {})
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
