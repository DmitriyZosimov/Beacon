import {Time, WeekDay} from "@angular/common";


export class Shop {
  constructor(public shopId?: BigInteger,
              public name?: string,
              public description?: string,
              public workingHoursMap?: Map<WeekDay, WorkingHours>,
              public paymentMethods?: Set<PaymentMethod>,
              public logo?: Logo) {
  }
}

export class WorkingHours {
  constructor(public id?: BigInteger,
              public open?: Date,
              public close?: Date) {

  }
}

export class Logo {
  constructor(public logoId?: BigInteger,
              public logo?: string) {

  }
}

export enum PaymentMethod {
  CASH = 'cash',
  DEBIT_CARD = 'debit card',
  CREDIT_CARD = 'credit card',
  MOBILE_PAYMENT = 'mobile payment',
  ELECTRONIC_BANK_TRANSFER = 'electronic bank transfer'
}
