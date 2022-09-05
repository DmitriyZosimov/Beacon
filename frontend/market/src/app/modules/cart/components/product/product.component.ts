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

  onChange(event: any, product: ProductModel) {
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

  onMinus(product: ProductModel) {
    --product.count;
    if (product.count < 0) {
      product.count = 0;
    }
    this.updateProduct.emit(product);
  }

  onPlus(product: ProductModel) {
    ++product.count;
    this.updateProduct.emit(product);
  }
}
