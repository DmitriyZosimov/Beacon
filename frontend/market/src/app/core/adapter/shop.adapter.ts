import {Injectable} from "@angular/core";
import {WeekDay} from "@angular/common";

import {PaymentMethodEnum, ShopModel, WorkingHoursModel} from "../../model/shop";

import {JavaLocalTimeAdapter} from "./java-local-time.adapter";

@Injectable({
  providedIn: 'root'
})
export class ShopAdapter {

  private constructor(
    private javaLocalTimeAdapter: JavaLocalTimeAdapter
  ) {}

  public adapt(value: any): ShopModel {
    let shopId = value.shopId;
    let name = value.name;
    let description = value.description;
    let workingHoursMap;
    if (value.workingHoursMap instanceof Array) {
      workingHoursMap = this.convertWorkingHoursMapFromArray(value.workingHoursMap);
    } else {
      workingHoursMap = this.convertWorkingHoursMap(value.workingHoursMap);
    }
    let paymentMethods: Set<PaymentMethodEnum> = new Set<PaymentMethodEnum>();
    value.paymentMethods?.forEach((v: any) => paymentMethods.add(v));
    let logo = value.logo;
    return new ShopModel(shopId, name, description, workingHoursMap, paymentMethods, logo);
  }

  /**
   * Backend serializes {@code Map<Object1, Object2>} to {@code List}. Where every {@code Object} include fields:
   * {@code key} is a key of the {@code Map<Object1, Object2>} - Object1,
   * {@code value} is a value of the {@code Map<Object1, Object2>} - Object2
   *
   * Convert from array that looks like:
   *
   * 0: {key: 'TUESDAY', value: {…}}
   * 1: {key: 'FRIDAY', value: {…}}
   * 2: {key: 'THURSDAY', value: {…}}
   * 3: {key: 'MONDAY', value: {…}}
   * 4: {key: 'WEDNESDAY', value: {…}}
   *
   * @param priorWorkingHours - this array
   */
  private convertWorkingHoursMapFromArray(priorWorkingHours: Array<any>) {
    let finalMap = new Map<WeekDay, WorkingHoursModel>();
    priorWorkingHours.forEach(element => {
      this.convert(element.key, element.value, finalMap);
    });
    return finalMap;
  }

  private convertWorkingHoursMap(priorWorkingHoursMap: any) {
    let priorMap: Map<string, WorkingHoursModel> = new Map(Object.entries(priorWorkingHoursMap));
    let finalMap = new Map<WeekDay, WorkingHoursModel>();
    priorMap.forEach((value, key) => this.convert(key, value, finalMap));
    return finalMap;
  }

  private convert(key: string, value: any, finalMap: Map<WeekDay, WorkingHoursModel>) {
    let workingHour = new WorkingHoursModel();
    workingHour.id = value.id;
    workingHour.open = this.javaLocalTimeAdapter.adapt('' + value.open);
    workingHour.close = this.javaLocalTimeAdapter.adapt('' + value.close);

    switch (key) {
      case 'MONDAY':
        finalMap.set(WeekDay.Monday, workingHour);
        break;
      case 'TUESDAY':
        finalMap.set(WeekDay.Tuesday, workingHour);
        break;
      case 'WEDNESDAY':
        finalMap.set(WeekDay.Wednesday, workingHour);
        break;
      case 'THURSDAY':
        finalMap.set(WeekDay.Thursday, workingHour);
        break;
      case 'FRIDAY':
        finalMap.set(WeekDay.Friday, workingHour);
        break;
      case 'SATURDAY':
        finalMap.set(WeekDay.Saturday, workingHour);
        break;
      case 'SUNDAY':
        finalMap.set(WeekDay.Sunday, workingHour);
        break;
      default:
        break;
    }
  }
}
