import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-image-list',
  templateUrl: './image-list.component.html',
  styleUrls: ['./image-list.component.css']
})
export class ImageListComponent implements OnInit {

  @Input('images') images!: Array<Object>;
  currentIndex = 0;

  constructor() { }

  ngOnInit(): void {
  }

}
