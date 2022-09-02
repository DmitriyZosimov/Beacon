export class CartFormModel {
  constructor(
    public isDeliveryToAddress: boolean = true,
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

  ) {}
}
