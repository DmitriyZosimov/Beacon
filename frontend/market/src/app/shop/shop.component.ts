import {Component, OnInit, ViewEncapsulation} from '@angular/core';

import {Router} from "@angular/router";
import {DomSanitizer, Meta, Title} from "@angular/platform-browser";
import {WeekDay} from "@angular/common";

import {ShopAdapter} from "../core/adapter";

import {ShopModel} from "../model/shop";
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
              private shopAdapter: ShopAdapter,
              private router: Router,
              private sanitizer: DomSanitizer,
              private metaService: Meta,
              private titleService: Title) {
  }

  ngOnInit(): void {
    this.shopService.getShopById(this.router.url).subscribe(response => {
      this.shop = this.shopAdapter.adapt(response.body);
      this.setupTitleAndMetaTags();
    })
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
