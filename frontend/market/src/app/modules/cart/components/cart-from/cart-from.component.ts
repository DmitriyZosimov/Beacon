import {Component, EventEmitter, OnInit, Output} from '@angular/core';

import {CartFormModel} from "../../models/cart-form.model";

@Component({
  selector: 'app-cart-from',
  templateUrl: './cart-from.component.html',
  styleUrls: ['./cart-from.component.css']
})
export class CartFromComponent implements OnInit {

  cartForm!: CartFormModel;
  @Output() submittedCartForm: EventEmitter<CartFormModel> = new EventEmitter<CartFormModel>();

  constructor() { }

  ngOnInit(): void {
    this.cartForm = new CartFormModel();
  }

  onChangeDelivery(toAddress: boolean) {
    this.cartForm.isDeliveryToAddress = toAddress;
  }

  onSaveCartForm() {
    this.submittedCartForm.emit(new CartFormModel(
      this.cartForm.isDeliveryToAddress,
      this.cartForm.firstName,
      this.cartForm.lastName,
      this.cartForm.email,
      this.cartForm.phoneNumber,
      this.cartForm.city,
      this.cartForm.street,
      this.cartForm.building,
      this.cartForm.flat,
      this.cartForm.porch,
      this.cartForm.floor,
      this.cartForm.comment
      ));
  }
}
