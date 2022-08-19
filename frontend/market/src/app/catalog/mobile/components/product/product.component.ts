import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {DomSanitizer} from "@angular/platform-browser";

import {MobileFullModel} from "../../../../model/mobile";
import {MobileService} from "../../service/mobile";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  mobileFull!: MobileFullModel | null;

  constructor(private mobileService: MobileService,
              private router: Router,
              private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    this.mobileService.getMobileFull(this.router.url).subscribe(response => {
      this.mobileFull = response.body;
    });
    console.log(this.mobileFull);
    console.log(this.router.url);
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

  getNotMainImages(): Array<Object> {
    let images = new Array<Object>();
    this.mobileFull?.notMainImages?.forEach(image => {
      let objectUrl = 'data:image/jpeg;base64,' + image.image;
      images.push(this.sanitizer.bypassSecurityTrustUrl(objectUrl))
    });
    return images;
  }

}
