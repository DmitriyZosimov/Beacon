import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";
import {DomSanitizer} from "@angular/platform-browser";
import {MobileService} from "../../../../../../service/mobile/mobile.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileDtoFull") mobileDtoFull?: MobileDtoFull;
  @Output() outputPage = new EventEmitter<number>();

  constructor(private mobileService: MobileService,
              private router: Router,
              private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
  }

  onBack() {
    this.page--;
    this.outputPage.emit(this.page);
  }

  onSave() {
    const mobile = {...this.mobileDtoFull} as MobileDtoFull;
    this.mobileService.createMobile(mobile)
  }

  getMainImage(): any {
    if (this.mobileDtoFull?.mainImage !== null) {
      let objectUrl = 'data:image/jpeg;base64,' + this.mobileDtoFull?.mainImage?.image;
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

  getMobileTitle(): string {
    let title = '';
    if (this.mobileDtoFull != null) {
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
}
