import {MobileModel} from "../mobile";

export class OrderModel {
  constructor(
    public orderId?: BigInteger,
    public mobileId?: string | number,
    public shopId?: BigInteger,
    public price?: number,
    public count?: number,
    public mobile?: MobileModel,
    public registeredDate?: Date
  ) {}
}
