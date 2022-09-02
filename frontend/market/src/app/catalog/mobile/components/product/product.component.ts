import {Component, HostListener, OnInit} from '@angular/core';
import {KeyValue} from "@angular/common";
import {ActivatedRoute, Router} from "@angular/router";
import {Meta, Title} from "@angular/platform-browser";

import {Observable, of} from "rxjs";

import {MobileFullModel} from "../../../../model/mobile";
import {MobileLayout} from "../../../../core/decorators";
import {ShopModel} from "../../../../model/shop";
import {MobileService} from "../../service/mobile";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
@MobileLayout('isMobileLayout')
export class ProductComponent implements OnInit {

  mobileFull!: MobileFullModel | null;
  isMobileLayout!: boolean;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private metaService: Meta,
              private titleService: Title,
              private mobileService: MobileService
              ) {
  }

  ngOnInit(): void {
    this.route.data.subscribe(data => {
      this.mobileFull = data.mobile;
    });
    this.setupMetaTagsAndTitle();
    this.isMobileLayout = window.screen.width <= 768;
  }

  getMobileTitle(): string {
    return this.mobileService.getMobileTitle(this.mobileFull!);
  }

  getShortDescription(): string {
    return this.mobileService.getMobileDescription(this.mobileFull!);
  }

  getMainImage(): any {
    return this.mobileService.getImage(this.mobileFull?.mainImage?.image!)
  }

  getMinimalPrice(): Observable<number | string> {
    let min = -1;
    this.mobileFull?.offers?.forEach(value => {
      if (min === -1 || min > value) {
        min = value;
      }
    });
    return min > 0 ? of('from ' + min) : of('out of stock');
  }

  getNotMainImages(): Array<Object> {
    let images = new Array<Object>();
    this.mobileFull?.notMainImages?.forEach(image => {
      images.push(this.mobileService.getImage(image.image!))
    });
    return images;
  }

  onAddToCart(offer: KeyValue<ShopModel, number>) {
    this.mobileService.addToCart(this.mobileFull!, offer);
  }

  @HostListener('window:resize')
  onResize(){}

  private setupMetaTagsAndTitle() {
    this.metaService.updateTag(
      {
        name: 'description',
        content: this.getShortDescription()
      });
    this.metaService.updateTag(
      {
        name: 'keywords',
        content: this.getKeywords()
      }
    );
    this.titleService.setTitle(this.getMobileTitle())
  }

  private getKeywords() {
    return `${this.mobileFull?.brand}, ${this.mobileFull?.model?.split(' ')}, Mobile, Phone, ` +
      `${this.mobileFull?.nfc ? 'NFC,': ''} ${this.mobileFull?.ram} GB, ${this.mobileFull?.storageCapacity} GB, ` +
      `${this.mobileFull?.battery} mAh, ${this.mobileFull?.releaseYear}, ${this.mobileFull?.cameraResolution} MP, ` +
      `${this.mobileFull?.fiveG ? '5G,': ''} ${this.mobileFull?.chipsetModel}, ${this.mobileFull?.color}, buy, new`
  }

}
