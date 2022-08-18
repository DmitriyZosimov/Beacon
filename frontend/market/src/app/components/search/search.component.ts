import {Component, OnInit} from '@angular/core';;
import {DomSanitizer} from "@angular/platform-browser";
import {Router} from "@angular/router";

import {SearchService} from "../../service";
import {MobileModel} from "../../model/mobile"

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchResults!: Array<MobileModel> | null;

  constructor(private searchService: SearchService,
              private router: Router,
              private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
  }

  onChange(event: any) {
    console.log(event.target.value);
    this.searchService.search(event.target.value).subscribe(value => {
      this.searchResults = value.body;
      console.log(this.searchResults);
    })
  }

  getDescriptionOfItem(item: MobileModel): string {
    let shortDescription = `${item.os}, screen ${item.screenSize}\" ${item.displayTechnology} (${item.displayResolution}` +
      `, ${item.chipsetModel}, RAM ${item.ram} GB, storage capacity ${item.storageCapacity} GB, camera ${item.cameraResolution} MP, ` +
      `battery ${item.battery} mAh, ${item.simCardSlot} SIM`;
    return shortDescription;
  }

  getTitleOfItem(item: MobileModel): string {
    let title = `${item.brand} ${item.model} ${item.ram}/${item.storageCapacity} (${item.color})`;
    return title;
  }

  getImageOfItem(item: MobileModel): any {
    if (item.mainImage !== null) {
      let objectUrl = 'data:image/jpeg;base64,' + item.mainImage?.image;
      let image = this.sanitizer.bypassSecurityTrustUrl(objectUrl);
      return image;
    }
  }

  getNavigationLink(item: MobileModel): void {
    this.searchResults = null;
    this.router.navigateByUrl('', {skipLocationChange: true}).then(() => {
      this.router.navigate(['mobile', item.brand?.toLocaleLowerCase().replace(/\s/g, ''),
        item.mobileId?.slice(item.brand?.length)]);
    });
  }
}
