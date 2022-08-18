import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forbidden-error',
  templateUrl: './forbidden-error.component.html',
  styleUrls: ['./forbidden-error.component.css']
})
export class ForbiddenErrorComponent implements OnInit {

  image!: string;

  constructor() { }

  ngOnInit(): void {
    if (window.screen.width <= 576) {
      this.image = '/assets/img/error_403_small.png'
    } else {
      this.image = '/assets/img/error_403.png'
    }
  }

}
