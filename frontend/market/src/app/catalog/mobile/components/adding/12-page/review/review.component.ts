import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Router} from "@angular/router";
import {DomSanitizer} from "@angular/platform-browser";

import {MobileFullModel} from "../../../../../../model/mobile";
import {MobileService} from "../../../../service/mobile";

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileFull") mobileFull?: MobileFullModel;
  @Output() outputPage = new EventEmitter<number>();

  constructor(private mobileService: MobileService,
              private router: Router,
              private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
  }

  onBack() {
    this.page--;
    this.outputPage.emit(this.page);
  }

  onSave() {
    const mobile = {...this.mobileFull} as MobileFullModel;
    this.mobileService.createMobile(mobile)
  }

  getMainImage(): any {
    if (this.mobileFull?.mainImage !== null) {
      let objectUrl = 'data:image/jpeg;base64,' + this.mobileFull?.mainImage?.image;
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

  getMobileTitle(): string {
    let title = '';
    if (this.mobileFull != null) {
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
}
