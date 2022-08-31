import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot} from "@angular/router";

//rxjs
import {Observable} from "rxjs";
import {finalize} from "rxjs/operators";
//from modules
import {SpinnerService} from "../../../widgets";

import {MobileService} from "../service/mobile";
import {MobileFullModel} from "../../../model/mobile";

@Injectable({
  providedIn: 'any'
})
export class ProductResolverGuard implements Resolve<MobileFullModel> {

  constructor(
    private mobileService: MobileService,
    private router: Router,
    private spinner: SpinnerService
  ) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<MobileFullModel> {
    this.spinner.show();
    return this.mobileService.getMobileFull(route.paramMap.get('brand'), route.paramMap.get('model'))
      .pipe(
        finalize(() => this.spinner.hide())
      )
  }

}
