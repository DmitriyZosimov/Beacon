import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-page-not-found',
  templateUrl: './page-not-found.component.html',
  styleUrls: ['./page-not-found.component.css']
})
export class PageNotFoundComponent implements OnInit {

  image!: string;

  constructor() { }

  ngOnInit(): void {
    if (window.screen.width <= 576) {
      console.log(window.screen.width)
      this.image = '/assets/img/error_404_small.png'
    } else {
      console.log(window.screen.width)
      this.image = '/assets/img/error_404.png'
    }
  }

}
