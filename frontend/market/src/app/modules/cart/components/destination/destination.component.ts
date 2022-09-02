import {Component, Input, OnInit} from '@angular/core';
import {CartFormModel} from "../../models/cart-form.model";

@Component({
  selector: 'app-destination',
  templateUrl: './destination.component.html',
  styleUrls: ['./destination.component.css']
})
export class DestinationComponent implements OnInit {

  @Input() cartForm!: CartFormModel;

  constructor() { }

  ngOnInit(): void {
  }

}
