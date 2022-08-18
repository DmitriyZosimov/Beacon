import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {DomSanitizer} from "@angular/platform-browser";

import {MobileModel} from "../../../../model/mobile";
import {MobileService} from "../../../../service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  mobiles!: Array<MobileModel> | null;

  constructor(private mobileService: MobileService,
              private router: Router,
              private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    this.getMobiles();
  }

  getMobiles(): void {
    this.mobileService.getMobiles().subscribe(response => {
      this.mobiles = response.body!;
    });
  }

  getNavigationLink(mobile: MobileModel): void {
    this.router.navigate(['mobile', mobile.brand?.toLocaleLowerCase().replace(/\s/g, ''),
    mobile.mobileId?.slice(mobile.brand?.length)]);
  }

  getMobileTitle(mobile: MobileModel): string {
    return `${mobile.brand} ${mobile.model} ${mobile.ram}/${mobile.storageCapacity} (${mobile.color})`;
  }

  getShortDescription(mobile: MobileModel): string {
    return `${mobile.os}, screen ${mobile.screenSize}\" ${mobile.displayTechnology} (${mobile.displayResolution}` +
      `, ${mobile.chipsetModel}, RAM ${mobile.ram} GB, storage capacity ${mobile.storageCapacity} GB, camera ${mobile.cameraResolution} MP, ` +
      `battery ${mobile.battery} mAh, ${mobile.simCardSlot} SIM`;
  }

  getImage(mobile: MobileModel): any {
    if (mobile.mainImage !== null) {
      let objectUrl = 'data:image/jpeg;base64,' + mobile.mainImage?.image;
      return this.sanitizer.bypassSecurityTrustUrl(objectUrl);
    }
  }
}
