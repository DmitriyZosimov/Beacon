import {Component, OnInit, ViewEncapsulation} from '@angular/core';

import {Router} from "@angular/router";
import {DomSanitizer, Meta, Title} from "@angular/platform-browser";
import {WeekDay} from "@angular/common";

import {JavaLocalTimeAdapter} from "../core/adapter";

import {PaymentMethodEnum, ShopModel, WorkingHoursModel} from "../model/shop";
import {ShopService} from "./service";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ShopComponent implements OnInit {

  shop!: ShopModel | null;

  currentDay = new Date();
  currentDayOfWeek = this.currentDay.getDay();

  constructor(private shopService: ShopService,
              private router: Router,
              private sanitizer: DomSanitizer,
              private metaService: Meta,
              private titleService: Title) {
  }

  ngOnInit(): void {
    this.shopService.getShopById(this.router.url).subscribe(response => {
      let shopId = response.body?.shopId;
      let name = response.body?.name;
      let description = response.body?.description;
      let workingHoursMap = this.convertMap(response.body?.workingHoursMap);
      let paymentMethods: Set<PaymentMethodEnum> = new Set<PaymentMethodEnum>();
      response.body?.paymentMethods?.forEach(v => paymentMethods.add(v));
      let logo = response.body?.logo;
      this.shop = new ShopModel(shopId, name, description, workingHoursMap, paymentMethods, logo);
      this.setupTitleAndMetaTags();
    })
  }

  private convertMap(priorWorkingHoursMap: any) {
    let priorMap: Map<string, WorkingHoursModel> = new Map(Object.entries(priorWorkingHoursMap));
    let finalMap = new Map<WeekDay, WorkingHoursModel>();
    priorMap.forEach((value, key) => {
      let workingHour = new WorkingHoursModel();
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
        default:
          break;
      }
    });
    return finalMap;
  }

  getLogo(): any {
    if (this.shop?.logo) {
      let objectUrl = 'data:image/jpeg;base64,' + this.shop.logo?.logo;
      return this.sanitizer.bypassSecurityTrustUrl(objectUrl);
    } else {
      return '/assets/img/no_logo_available.png'
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
    return this.shop?.workingHoursMap?.get(day)?.open;
  }

  workTo(dayOfWeek?: number) {
    let day = dayOfWeek === undefined ? this.currentDayOfWeek : dayOfWeek;
    return this.shop?.workingHoursMap?.get(day)?.close;
  }

  checkWorkingHours(number: number): boolean {
    switch (number) {
      case 1:
        return !!this.shop?.workingHoursMap?.has(WeekDay.Monday);
      case 2:
        return !!this.shop?.workingHoursMap?.has(WeekDay.Tuesday);
      case 3:
        return !!this.shop?.workingHoursMap?.has(WeekDay.Wednesday);
      case 4:
        return !!this.shop?.workingHoursMap?.has(WeekDay.Thursday);
      case 5:
        return !!this.shop?.workingHoursMap?.has(WeekDay.Friday);
      case 6:
        return !!this.shop?.workingHoursMap?.has(WeekDay.Saturday);
      case 0:
        return !!this.shop?.workingHoursMap?.has(WeekDay.Sunday);
      default:
        return false;
    }
  }

  private setupTitleAndMetaTags() {
    this.titleService.setTitle(this.shop?.name!);
    this.metaService.updateTag(
      {
        name: 'description',
        content: this.shop?.description!
      }
    );
    this.metaService.updateTag(
      {
        name: 'keywords',
        content: 'shops are in Beacon'
      }
    )
  }

}
