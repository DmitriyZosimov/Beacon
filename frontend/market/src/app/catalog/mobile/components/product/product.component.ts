import {Component, HostListener, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {DomSanitizer, Meta, Title} from "@angular/platform-browser";

import {Observable, of} from "rxjs";

import {MobileFullModel} from "../../../../model/mobile";
import {MobileLayout} from "../../../../core/decorators";

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
              private sanitizer: DomSanitizer,
              private metaService: Meta,
              private titleService: Title) {
  }

  ngOnInit(): void {
    this.route.data.subscribe(data => {
      this.mobileFull = data.mobile;
    });
    this.setupMetaTagsAndTitle();
    this.isMobileLayout = window.screen.width <= 768;
  }

  getMobileTitle(): string {
    let title = '';
    if (this.mobileFull !== undefined && this.mobileFull !== null) {
      if (this.mobileFull.brand != null) {
        title = title.concat(this.mobileFull.brand);
      }
      if (this.mobileFull.model !== null) {
        title = title.concat(' ' + this.mobileFull.model);
      }
      if (this.mobileFull.ram !== null) {
        title = title.concat(' ' + this.mobileFull.ram);
      }
      if (this.mobileFull.storageCapacity !== null) {
        title = title.concat('/' + this.mobileFull.storageCapacity);
      }
      if (this.mobileFull.color !== null) {
        title = title.concat(' (' + this.mobileFull.color + ')')
      }
    }
    return title;
  }

  getShortDescription(): string {
    let shortDescription = '';
    if (this.mobileFull !== undefined && this.mobileFull !== null) {
      if (this.mobileFull.os !== null) {
        shortDescription = shortDescription.concat(this.mobileFull.os + ', ');
      }
      if (this.mobileFull.screenSize !== null) {
        shortDescription = shortDescription.concat('screen ' + this.mobileFull.screenSize + '\", ');
      }
      if (this.mobileFull.displayTechnology !== null) {
        shortDescription = shortDescription.concat(this.mobileFull.displayTechnology + ', ');
      }
      if (this.mobileFull.displayResolution !== null) {
        shortDescription = shortDescription.concat('(' + this.mobileFull.displayResolution + '), ');
      }
      if (this.mobileFull.chipsetModel !== null) {
        shortDescription = shortDescription.concat(this.mobileFull.chipsetModel + ', ');
      }
      if (this.mobileFull.ram !== null) {
        shortDescription = shortDescription.concat('RAM ' + this.mobileFull.ram + ' GB, ');
      }
      if (this.mobileFull.storageCapacity !== null) {
        shortDescription = shortDescription.concat('storage capacity ' + this.mobileFull.storageCapacity + ' GB, ');
      }
      if (this.mobileFull.cameraResolution !== null) {
        shortDescription = shortDescription.concat('camera ' + this.mobileFull.cameraResolution + ' MP, ');
      }
      if (this.mobileFull.battery !== null) {
        shortDescription = shortDescription.concat('battery ' + this.mobileFull.battery + ' mAh, ');
      }
      if (this.mobileFull.simCardSlot !== null) {
        shortDescription = shortDescription.concat(this.mobileFull.simCardSlot + ' SIM');
      }
      shortDescription = shortDescription.trim();
      if (shortDescription.endsWith(',')) {
        shortDescription = shortDescription.slice(0, -1)
      }
    }
    return shortDescription;
  }

  getMainImage(): any {
    if (this.mobileFull != null && this.mobileFull.mainImage !== null) {
      let objectUrl = 'data:image/jpeg;base64,' + this.mobileFull.mainImage?.image;
      return this.sanitizer.bypassSecurityTrustUrl(objectUrl);
    }
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
      let objectUrl = 'data:image/jpeg;base64,' + image.image;
      images.push(this.sanitizer.bypassSecurityTrustUrl(objectUrl))
    });
    return images;
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
