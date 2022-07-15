import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-carousel',
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {

  @Input('images') images!: Array<Object>;
  @Input('first') first!: number;

  constructor() {
  }

  ngOnInit(): void {
  }

}
