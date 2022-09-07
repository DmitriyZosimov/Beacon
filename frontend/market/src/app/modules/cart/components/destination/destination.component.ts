import {Component, OnDestroy, OnInit} from '@angular/core';

// @ngrx
import {select, Store} from "@ngrx/store";

//@rxjs
import {takeUntil} from "rxjs/operators";
import {Subject} from "rxjs";

import {CartFormModel} from "../../models/cart-form.model";
import {AppState} from "../../../../core/@ngrx";
import {selectCartForm} from "../../@ngrx";

@Component({
  selector: 'app-destination',
  templateUrl: './destination.component.html',
  styleUrls: ['./destination.component.css']
})
export class DestinationComponent implements OnInit, OnDestroy {

  cartForm!: CartFormModel;
  private componentDestroyed$: Subject<void> = new Subject<void>();

  constructor(
    private store: Store<AppState>
  ) {
  }

  ngOnInit(): void {
    let observer = {
      next: (cartForm: CartFormModel) => {
        this.cartForm = {...cartForm};
      },
      error(err: Error | string) {
        console.log(err);
      },
      complete() {
        console.log('Stream is completed')
      }
    };

    this.store.pipe(
      select(selectCartForm),
      takeUntil(this.componentDestroyed$)
    ).subscribe(observer);
  }

  ngOnDestroy(): void {
    this.componentDestroyed$.next();
    this.componentDestroyed$.complete();
  }

}
