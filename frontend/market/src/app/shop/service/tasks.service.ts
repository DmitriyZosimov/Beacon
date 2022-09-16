import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ShopAPI} from "../shop.config";

import {Observable} from "rxjs";
import {catchError, map} from "rxjs/operators";

import {ErrorHandlerService} from "../../core/services";
import {Cookie} from "ng2-cookies";
import {TaskModel} from "../../model/task";

@Injectable({
  providedIn: 'any'
})
export class TasksService {

  constructor(
    private httpClient: HttpClient,
    private errorHandler: ErrorHandlerService,
    @Inject(ShopAPI) private shopServer: string
  ) { }

  getTasks(id: string): Observable<Array<TaskModel>> {
    // let headers = new HttpHeaders({
    //   'Content-type': 'application/json; charset=utf-8',
    //   'Authorization': 'Bearer ' + Cookie.get('access_token')
    // });
    return this.httpClient.get<Array<TaskModel>>(`http://localhost:8010/shop/${id}/tasks`, {
      // headers: headers,
      responseType: 'json',
      observe: "response"
    })
      .pipe(
        map(response => response.body || []),
        catchError((err) => this.errorHandler.handleError(err))
      );
  }

  updateTask(id: string, task: TaskModel): Observable<TaskModel> {
    let headers = new HttpHeaders({
      'Content-type': 'application/json; charset=utf-8',
      'Authorization': 'Bearer ' + Cookie.get('access_token')
    });
    return this.httpClient.put(`${this.shopServer}/${id}/tasks`, {
      headers: headers,
      responseType: 'json',
      observe: 'response'
    }).pipe(
      map(response => task),
      catchError(error => this.errorHandler.handleError(error))
    );
  }
}
