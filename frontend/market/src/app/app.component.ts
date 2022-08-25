import {Component, OnDestroy, OnInit} from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {Title} from '@angular/platform-browser';

//rxjs
import {Subscription} from "rxjs";
import {filter, map, switchMap} from "rxjs/operators";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {

  private sub: { [key: string]: Subscription } = {};

  constructor(private titleService: Title,
              private router: Router) {
  }

  ngOnInit(): void {
    this.setPageTitles();
  }

  ngOnDestroy(): void {
    this.sub.navigationEnd.unsubscribe();
  }

  private setPageTitles(): void {
    this.sub.navigationEnd = this.router.events
      .pipe(
        filter(event => event instanceof NavigationEnd),
        map(() => this.router.routerState.root),
        map(route => {
          while (route.firstChild) {
            route = route.firstChild;
          }
          return route;
        }),
        switchMap(route => route.data)
      )
      .subscribe(
        data => this.titleService.setTitle(data.title)
      );
  }
}
