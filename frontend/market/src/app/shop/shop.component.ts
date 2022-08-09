import {Component, OnInit, ViewEncapsulation} from '@angular/core';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ShopComponent implements OnInit {

  mo = true;
  tu = true;
  we = false;
  th = true;
  fr = true;
  st = true;
  su = false;
  currentDay = new Date().getDay();

  paymentMethods = ['cash', 'card', 'nfc'];

  constructor() {
  }

  ngOnInit(): void {
  }

  isOpen() {
    return false;
  }

  workFrom() {
    return '09:00'
  }

  workTo() {
    return '21:00'
  }
}
