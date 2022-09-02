import {Component, EventEmitter, HostListener, Input, OnInit, Output} from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";

import {ShopModel} from "../../../../../model/shop";
import {MobileLayout} from "../../../../../core/decorators";
import {KeyValue} from "@angular/common";


@Component({
  selector: 'app-shop-list',
  templateUrl: './shop-list.component.html',
  styleUrls: ['./shop-list.component.css']
})

@MobileLayout()
export class ShopListComponent implements OnInit {

  @Input() offers!: Map<ShopModel, number> | undefined;
  @Output() selectedOffer = new EventEmitter<KeyValue<ShopModel, number>>();

  currentDay = new Date();
  currentDayOfWeek = this.currentDay.getDay();

  isMobileLayout!: boolean;

  constructor(
    private sanitizer: DomSanitizer
  ) { }

  ngOnInit(): void {
    this.isMobileLayout = window.screen.width <= 768;
  }

  getLogo(shop: ShopModel) {
    if (shop?.logo) {
      let objectUrl = 'data:image/jpeg;base64,' + shop.logo?.logo;
      return this.sanitizer.bypassSecurityTrustUrl(objectUrl);
    } else {
      return '/assets/img/no_logo_available.png'
    }
  }

  isOpen(shop: ShopModel) {
    if (shop.workingHoursMap?.has(this.currentDayOfWeek)) {
      return false;
    }
    return !!(shop.workingHoursMap?.get(this.currentDayOfWeek)?.open?.getHours()! <= this.currentDay.getHours() &&
      shop.workingHoursMap?.get(this.currentDayOfWeek)?.close?.getHours()! >= this.currentDay.getHours());
  }

  onAddToCart(offer: KeyValue<ShopModel, number>) {
    this.selectedOffer.emit(offer);
  }

  workFrom(shop: ShopModel, dayOfWeek?: number) {
    let day = dayOfWeek === undefined ? this.currentDayOfWeek : dayOfWeek;
    return shop.workingHoursMap?.get(day)?.open;
  }

  workTo(shop: ShopModel, dayOfWeek?: number) {
    let day = dayOfWeek === undefined ? this.currentDayOfWeek : dayOfWeek;
    return shop.workingHoursMap?.get(day)?.close;
  }

  @HostListener('window:resize')
  onResize(){}
}
