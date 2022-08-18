import {WeekDay} from "@angular/common";
import {WorkingHoursModel} from "./working-hours.model";
import {Logo} from "./logo.model";
import {PaymentMethodEnum} from "./payment-method.enum";


export class ShopModel {
  constructor(public shopId?: BigInteger,
              public name?: string,
              public description?: string,
              public workingHoursMap?: Map<WeekDay, WorkingHoursModel>,
              public paymentMethods?: Set<PaymentMethodEnum>,
              public logo?: Logo) {
  }
}
