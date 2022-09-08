import {Component, OnDestroy, OnInit} from '@angular/core';

// @ngrx
import {select, Store} from "@ngrx/store";

//@rxjs
import {takeUntil} from "rxjs/operators";
import {Subject} from "rxjs";

import {DestinationModel} from "../../models/destination.model";
import {AppState} from "../../../../core/@ngrx";
import {selectDestination} from "../../@ngrx";

@Component({
  selector: 'app-destination',
  templateUrl: './destination.component.html',
  styleUrls: ['./destination.component.css']
})
export class DestinationComponent implements OnInit, OnDestroy {

  destination!: DestinationModel;
  private componentDestroyed$: Subject<void> = new Subject<void>();

  constructor(
    private store: Store<AppState>
  ) {
  }

  ngOnInit(): void {
    let observer = {
      next: (destination: DestinationModel) => {
        this.destination = {...destination};
      },
      error(err: Error | string) {
        console.log(err);
      },
      complete() {
        console.log('Stream is completed')
      }
    };

    this.store.pipe(
      select(selectDestination),
      takeUntil(this.componentDestroyed$)
    ).subscribe(observer);
  }

  ngOnDestroy(): void {
    this.componentDestroyed$.next();
    this.componentDestroyed$.complete();
  }

}
