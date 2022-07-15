import {Component, OnInit} from '@angular/core';
import {MobileDtoFull} from "../../../../model/mobile/mobile-dto";

@Component({
  selector: 'app-adding',
  templateUrl: './adding.component.html',
  styleUrls: ['./adding.component.css']
})
export class AddingComponent implements OnInit {

  page = 1;
  pages!: Array<number>;
  progress = 0;

  mobileDtoFull = new MobileDtoFull();

  constructor() {
  }

  ngOnInit(): void {
    this.pages = new Array(12).fill(1).map((x, i) => i + 1);
    console.log('progress' + this.progress)
  }

  changePage(page: number) {
    this.page = page;
    this.progress = ((this.page - 1)/(this.pages.length - 1))*100;
  }
}
