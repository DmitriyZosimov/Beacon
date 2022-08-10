import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ShopService} from "../service/shop/shop.service";
import {PaymentMethod, Shop, WorkingHours} from "../model/shop/shop";
import {Router} from "@angular/router";
import {DomSanitizer} from "@angular/platform-browser";
import {WeekDay} from "@angular/common";
import {JavaLocalTimeAdapter} from "../adapter/java-local-time.adapter";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ShopComponent implements OnInit {

  shop!: Shop | null;

  currentDay = new Date();
  currentDayOfWeek = this.currentDay.getDay();

  constructor(private shopService: ShopService,
              private router: Router,
              private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    this.shopService.getShopById(this.router.url).subscribe(response => {
      let shopId = response.body?.shopId;
      let name = response.body?.name;
      let description = response.body?.description;
      let workingHoursMap = this.convertMap(response.body?.workingHoursMap);
      let paymentMethods: Set<PaymentMethod> = new Set<PaymentMethod>();
      response.body?.paymentMethods?.forEach(v => paymentMethods.add(v));
      let logo = response.body?.logo;
      this.shop = new Shop(shopId, name, description, workingHoursMap, paymentMethods, logo);
    })
  }

  private convertMap(priorWorkingHoursMap: any) {
    let priorMap: Map<string, WorkingHours> = new Map(Object.entries(priorWorkingHoursMap));
    let finalMap = new Map<WeekDay, WorkingHours>();
    priorMap.forEach((value, key) => {
      let workingHour = new WorkingHours();
      workingHour.id = value.id;
      workingHour.open = JavaLocalTimeAdapter.adapt('' + value.open);
      workingHour.close = JavaLocalTimeAdapter.adapt('' + value.close);

      switch (key) {
        case 'MONDAY':
          finalMap.set(WeekDay.Monday, workingHour);
          break;
        case 'TUESDAY':
          finalMap.set(WeekDay.Tuesday, workingHour);
          break;
        case 'WEDNESDAY':
          finalMap.set(WeekDay.Wednesday, workingHour);
          break;
        case 'THURSDAY':
          finalMap.set(WeekDay.Thursday, workingHour);
          break;
        case 'FRIDAY':
          finalMap.set(WeekDay.Friday, workingHour);
          break;
        case 'SATURDAY':
          finalMap.set(WeekDay.Saturday, workingHour);
          break;
        case 'SUNDAY':
          finalMap.set(WeekDay.Sunday, workingHour);
          break;
        default: break;
      }
    });
    return finalMap;
  }

  getLogo(): any {
    if (this.shop?.logo) {
      let objectUrl = 'data:image/jpeg;base64,' + this.shop.logo?.logo;
      return this.sanitizer.bypassSecurityTrustUrl(objectUrl);
    } else {
      return '/assets/img/beacon-small-logo.png'
    }
  }

  isOpen() {
    if (!this.shop?.workingHoursMap?.has(this.currentDayOfWeek)) {
      return false;
    }
    return !!(this.shop?.workingHoursMap?.get(this.currentDayOfWeek)?.open?.getHours()! <= this.currentDay.getHours() &&
      this.shop?.workingHoursMap?.get(this.currentDayOfWeek)?.close?.getHours()! >= this.currentDay.getHours());
  }

  workFrom(dayOfWeek?: number) {
    let day = dayOfWeek === undefined ? this.currentDayOfWeek : dayOfWeek;
    let time = this.shop?.workingHoursMap?.get(day)?.open?.toLocaleTimeString();
    if (time === undefined) {
      return '-'
    } else {
      return time.slice(0, time.lastIndexOf(':'))! + time?.slice(time.lastIndexOf(':') + 3);
    }
  }

  workTo(dayOfWeek?: number) {
    let day = dayOfWeek === undefined ? this.currentDayOfWeek : dayOfWeek;
    let time = this.shop?.workingHoursMap?.get(day)?.close?.toLocaleTimeString();
    if (time === undefined) {
      return '-'
    } else {
      return time.slice(0, time.lastIndexOf(':'))! + time?.slice(time.lastIndexOf(':') + 3);
    }
  }

  checkWorkingHours(number: number): boolean {
      switch (number) {
        case 1: return !!this.shop?.workingHoursMap?.has(WeekDay.Monday);
        case 2: return !!this.shop?.workingHoursMap?.has(WeekDay.Tuesday);
        case 3: return !!this.shop?.workingHoursMap?.has(WeekDay.Wednesday);
        case 4: return !!this.shop?.workingHoursMap?.has(WeekDay.Thursday);
        case 5: return !!this.shop?.workingHoursMap?.has(WeekDay.Friday);
        case 6: return !!this.shop?.workingHoursMap?.has(WeekDay.Saturday);
        case 0: return !!this.shop?.workingHoursMap?.has(WeekDay.Sunday);
        default:
          return false;
      }
  }

}
