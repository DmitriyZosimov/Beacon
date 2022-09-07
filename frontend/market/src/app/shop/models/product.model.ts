export class ProductModel {
  constructor(
    public productId: number | string,
    public brand: string,
    public model: string,
    public color: string,
    public price: number,
    public orderDate: Date,
    public itemNumber?: string
  ){}
}
