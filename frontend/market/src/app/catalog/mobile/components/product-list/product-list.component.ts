import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

import {MobileModel} from "../../../../model/mobile";
import {MobileService} from "../../service/mobile";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  mobiles!: Array<MobileModel> | null;

  constructor(private mobileService: MobileService,
              private router: Router) {
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
    return this.mobileService.getMobileTitle(mobile);
  }

  getShortDescription(mobile: MobileModel): string {
    return this.mobileService.getMobileDescription(mobile);
  }

  getImage(mobile: MobileModel): any {
    return this.mobileService.getImage(mobile.mainImage?.image!);
  }
}
