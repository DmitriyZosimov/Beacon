import { Component, OnInit } from '@angular/core';
import {TaskModel} from "../../../models/task.model";
import {DestinationModel} from "../../../models/destination.model";
import {ProductModel} from "../../../models/product.model";

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks!: Array<TaskModel>;
  constructor() { }

  ngOnInit(): void {
    this.tasks = [];
    let destination = new DestinationModel('Dmitriy', 'Zosimov', 'zos@mail.ru', '+375291397045',
      'Minsk', 'atakum bulvari', '187', 4, 1, 7, 'I want a pizza', 1);
    let newProduct = new ProductModel(1, 'Apple', '13', 'black', 1100.6, new Date(), '111');
    this.tasks.push(new TaskModel(1, destination, [newProduct, newProduct], false));
    this.tasks.push(new TaskModel(1, destination, [newProduct, newProduct], true));
  }

}
