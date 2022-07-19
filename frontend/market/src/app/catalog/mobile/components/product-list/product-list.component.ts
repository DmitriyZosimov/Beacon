import {Component, OnInit} from '@angular/core';
import {MobileService} from "../../../../service/mobile/mobile.service";
import {Router} from "@angular/router";
import {MobileDto} from "../../../../model/mobile/mobile-dto";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  mobileDtos!: Array<MobileDto> | null;

  constructor(private mobileService: MobileService,
              private router: Router,
              private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    this.getMobileDtos();
  }

  getMobileDtos(): void {
    this.mobileService.getMobileDtos().subscribe(response => {
      this.mobileDtos = response.body!;
    });
  }

  getNavigationLink(mobileDto: MobileDto): void {
    this.router.navigate(['mobile', mobileDto.brand?.toLocaleLowerCase().replace(/\s/g, ''),
    mobileDto.mobileId?.slice(mobileDto.brand?.length)]);
  }

  getMobileTitle(mobileDto: MobileDto): string {
    let title = `${mobileDto.brand} ${mobileDto.model} ${mobileDto.ram}/${mobileDto.storageCapacity} (${mobileDto.color})`;
    return title;
  }

  getShortDescription(mobileDto: MobileDto): string {
    let shortDescription = `${mobileDto.os}, screen ${mobileDto.screenSize}\" ${mobileDto.displayTechnology} (${mobileDto.displayResolution}` +
      `, ${mobileDto.chipsetModel}, RAM ${mobileDto.ram} GB, storage capacity ${mobileDto.storageCapacity} GB, camera ${mobileDto.cameraResolution} MP, ` +
      `battery ${mobileDto.battery} mAh, ${mobileDto.simCardSlot} SIM`;
    return shortDescription;
  }

  getImage(mobileDto: MobileDto): any {
    if (mobileDto.mainImage !== null) {
      let objectUrl = 'data:image/jpeg;base64,' + mobileDto.mainImage?.image;
      let image = this.sanitizer.bypassSecurityTrustUrl(objectUrl);
      return image;
    }
  }
}
