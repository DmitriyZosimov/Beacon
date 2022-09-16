import {OrderModel} from "./order.model";
import {TaskStateEnum} from "./task-state.enum";

export class TaskModel {
  constructor(
    public firstName: string = '',
    public lastName: string = '',
    public email: string = '',
    public phoneNumber: string = '+375',
    public city: string = 'Minsk',
    public street: string = '',
    public building: string = '',
    public flat?: number,
    public porch?: number,
    public floor?: number,
    public comment?: string,
    public taskId?: BigInteger,
    public orders?: Array<OrderModel>,
    public isDeliveryToAddress: boolean = true,
    public state: TaskStateEnum = TaskStateEnum.NEW
  ) {}
}
