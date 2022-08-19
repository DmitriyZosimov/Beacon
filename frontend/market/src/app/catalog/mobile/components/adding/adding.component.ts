import {Component, OnInit} from '@angular/core';

import {MobileFullModel} from "../../../../model/mobile";
import {MobileService} from "../../service/mobile";

@Component({
  selector: 'app-adding',
  templateUrl: './adding.component.html',
  styleUrls: ['./adding.component.css']
})
export class AddingComponent implements OnInit {

  page = 1;
  pages!: Array<number>;
  progress = 0;

  mobileFull = new MobileFullModel();

  constructor(
    private mobileService: MobileService,
  ) {
  }

  ngOnInit(): void {
    this.pages = new Array(12).fill(1).map((x, i) => i + 1);
    console.log('progress' + this.progress)
  }

  changePage(page: number) {
    this.page = page;
    this.progress = ((this.page - 1)/(this.pages.length - 1))*100;
  }

  onSave(mobile: MobileFullModel) {
    this.mobileService.createMobile(mobile);
  }
}
