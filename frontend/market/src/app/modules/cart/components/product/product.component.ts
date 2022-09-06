import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ProductModel} from "../../../../model/product";
import {CartService} from "../../services";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() product!: ProductModel;
  @Output() deleteProduct: EventEmitter<ProductModel> = new EventEmitter<ProductModel>();
  @Output() updateProduct: EventEmitter<ProductModel> = new EventEmitter<ProductModel>();

  constructor(
    private cartService: CartService
  ) { }

  ngOnInit(): void {
  }

  getProductImage() {
    return this.cartService.adaptImage(this.product.productImage!);
  }

  getShopImage() {
    return this.cartService.adaptImage(this.product.shopImage!);
  }

  onChange(event: any) {
    const product = {...this.product};
    if (event.target.value < 0) {
      product.count = 0;
    } else {
      product.count = event.target.value;
    }
    this.updateProduct.emit(product);
  }

  onDelete(product: ProductModel) {
    this.deleteProduct.emit(product);
  }

  onMinus() {
    const product = {...this.product};
    --product.count;
    if (product.count < 0) {
      product.count = 0;
    }
    this.updateProduct.emit(product);
  }

  onPlus() {
    const product = {...this.product};
    ++product.count;
    this.updateProduct.emit(product);
  }
}
