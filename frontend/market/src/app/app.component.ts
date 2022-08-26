import {Component, OnInit} from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {Meta, Title} from '@angular/platform-browser';

//rxjs
import {Subscription} from "rxjs";
import {filter, map, switchMap} from "rxjs/operators";
import {AutoUnsubscribe} from "./core/decorators";
import {SpinnerService} from "./widgets";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
@AutoUnsubscribe('sub')
export class AppComponent implements OnInit {

  private sub: { [key: string]: Subscription } = {};

  constructor(public spinnerService: SpinnerService,
              private titleService: Title,
              private metaService: Meta,
              private router: Router) {
  }

  ngOnInit(): void {
    this.setPageTitlesAndMetaTags();
  }

  private setPageTitlesAndMetaTags(): void {
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
        data => {
          this.titleService.setTitle(data.title);
          this.metaService.removeTag("name='description'");
          this.metaService.removeTag("name='keywords'");
          this.metaService.addTags(data.meta);
        }
      );
  }
}
