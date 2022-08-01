import {Component, OnInit} from '@angular/core';
import {MobileDtoFull} from "../../../../model/mobile/mobile-dto";
import {MobileService} from "../../../../service/mobile/mobile.service";
import {Router} from "@angular/router";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  mobileDtoFull!: MobileDtoFull | null;

  constructor(private mobileService: MobileService,
              private router: Router,
              private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    this.mobileService.getMobileDtoFull(this.router.url).subscribe(response => {
      this.mobileDtoFull = response.body;
    });
    console.log(this.mobileDtoFull);
    console.log(this.router.url);
  }

  getMobileTitle(): string {
    let title = '';
    if (this.mobileDtoFull !== undefined && this.mobileDtoFull !== null) {
      if (this.mobileDtoFull.brand != null) {
        title = title.concat(this.mobileDtoFull.brand);
      }
      if (this.mobileDtoFull.model !== null) {
        title = title.concat(' ' + this.mobileDtoFull.model);
      }
      if (this.mobileDtoFull.ram !== null) {
        title = title.concat(' ' + this.mobileDtoFull.ram);
      }
      if (this.mobileDtoFull.storageCapacity !== null) {
        title = title.concat('/' + this.mobileDtoFull.storageCapacity);
      }
      if (this.mobileDtoFull.color !== null) {
        title = title.concat(' (' + this.mobileDtoFull.color + ')')
      }
    }
    return title;
  }

  getShortDescription(): string {
    let shortDescription = '';
    if (this.mobileDtoFull !== undefined && this.mobileDtoFull !== null) {
      if (this.mobileDtoFull.os !== null) {
        shortDescription = shortDescription.concat(this.mobileDtoFull.os + ', ');
      }
      if (this.mobileDtoFull.screenSize !== null) {
        shortDescription = shortDescription.concat('screen ' + this.mobileDtoFull.screenSize + '\", ');
      }
      if (this.mobileDtoFull.displayTechnology !== null) {
        shortDescription = shortDescription.concat(this.mobileDtoFull.displayTechnology + ', ');
      }
      if (this.mobileDtoFull.displayResolution !== null) {
        shortDescription = shortDescription.concat('(' + this.mobileDtoFull.displayResolution + '), ');
      }
      if (this.mobileDtoFull.chipsetModel !== null) {
        shortDescription = shortDescription.concat(this.mobileDtoFull.chipsetModel + ', ');
      }
      if (this.mobileDtoFull.ram !== null) {
        shortDescription = shortDescription.concat('RAM ' + this.mobileDtoFull.ram + ' GB, ');
      }
      if (this.mobileDtoFull.storageCapacity !== null) {
        shortDescription = shortDescription.concat('storage capacity ' + this.mobileDtoFull.storageCapacity + ' GB, ');
      }
      if (this.mobileDtoFull.cameraResolution !== null) {
        shortDescription = shortDescription.concat('camera ' + this.mobileDtoFull.cameraResolution + ' MP, ');
      }
      if (this.mobileDtoFull.battery !== null) {
        shortDescription = shortDescription.concat('battery ' + this.mobileDtoFull.battery + ' mAh, ');
      }
      if (this.mobileDtoFull.simCardSlot !== null) {
        shortDescription = shortDescription.concat(this.mobileDtoFull.simCardSlot + ' SIM');
      }
      shortDescription = shortDescription.trim();
      if (shortDescription.endsWith(',')) {
        shortDescription = shortDescription.slice(0, -1)
      }
    }
    return shortDescription;
  }

  getMainImage(): any {
    if (this.mobileDtoFull != null && this.mobileDtoFull.mainImage !== null) {
      let objectUrl = 'data:image/jpeg;base64,' + this.mobileDtoFull.mainImage?.image;
      return this.sanitizer.bypassSecurityTrustUrl(objectUrl);
    }
  }

  getNotMainImages(): Array<Object> {
    let images = new Array<Object>();
    this.mobileDtoFull?.notMainImages?.forEach(image => {
      let objectUrl = 'data:image/jpeg;base64,' + image.image;
      images.push(this.sanitizer.bypassSecurityTrustUrl(objectUrl))
    });
    return images;
  }

}
