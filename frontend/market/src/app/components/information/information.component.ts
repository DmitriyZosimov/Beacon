import { Component, OnInit } from '@angular/core';
import {interval, Observable, of} from "rxjs";
import {mergeMap} from "rxjs/operators";

@Component({
  selector: 'app-information',
  templateUrl: './information.component.html',
  styleUrls: ['./information.component.css']
})
export class InformationComponent implements OnInit {

  currentTime!: Observable<String>;
  constructor() {
  }

  ngOnInit(): void {
    // this.currentTime = this.getClock();
  }

  getClock() : Observable<String> {
    return interval(1000).pipe(
      mergeMap(() => of(new Date().toLocaleTimeString()))
    )
  }

}
