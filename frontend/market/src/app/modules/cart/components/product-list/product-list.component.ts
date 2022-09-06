import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

import {Observable} from "rxjs";
//@ngrx
import {select, Store} from "@ngrx/store";
import {AppState} from "../../../../core/@ngrx";

import {CartService} from "../../services";
import {ProductModel} from "../../../../model/product";
import {ErrorHandlerService} from "../../../../core/services";
import {CartState, updateProduct} from "../../@ngrx";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products$!: Observable<CartState>;

  constructor(
    private cartService: CartService,
    private cartStore: Store<AppState>,
    private errorService: ErrorHandlerService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.products$ = this.cartStore.pipe(select('cart'));
  }

  onDeleteProduct(product: ProductModel) {
    this.cartService.deleteProduct(product);
  }

  onUpdateProduct(product: ProductModel) {
    this.cartStore.dispatch(updateProduct({ product }));
  }

  get finalBill() {
    let bill = 0;
    this.products$.subscribe(products => products.data.forEach(product => bill += product.price! * product.count));
    return bill;
  }

  onBuy() {
    // this.cartService.saveOrder(this.cartForm)
    //   .subscribe(status => {
    //       if (status === 200) {
    //         this.router.navigate(['/success'])
    //       } else {
    //         this.router.navigate(['/fail'])
    //       }
    //     },
    //     error => this.errorService.handleError(error)
    //   )
  }
}
