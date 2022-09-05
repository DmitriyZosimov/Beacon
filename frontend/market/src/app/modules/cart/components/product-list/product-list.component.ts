import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

import {Observable} from "rxjs";

import {CartService} from "../../services";
import {ProductModel} from "../../../../model/product";
import {CartFormModel} from "../../models/cart-form.model";
import {ErrorHandlerService} from "../../../../core/services";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products$!: Observable<Array<ProductModel>>;

  @Input() cartForm!: CartFormModel;

  constructor(
    private cartService: CartService,
    private errorService: ErrorHandlerService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.products$ = this.cartService.getProducts();
  }

  onDeleteProduct(product: ProductModel) {
    this.cartService.deleteProduct(product);
  }

  onUpdateProduct(product: ProductModel) {
    this.cartService.updateProduct(product);
  }

  get finalBill() {
    let bill = 0;
    this.products$.subscribe(products => products.forEach(product => bill += product.price! * product.count));
    return bill;
  }

  onBuy() {
    this.cartService.saveOrder(this.cartForm)
      .subscribe(status => {
          if (status === 200) {
            this.router.navigate(['/success'])
          } else {
            this.router.navigate(['/fail'])
          }
        },
        error => this.errorService.handleError(error)
      )
  }

  onSubmitCartForm(submittedCartForm: CartFormModel) {
    this.cartForm = submittedCartForm;
  }
}
