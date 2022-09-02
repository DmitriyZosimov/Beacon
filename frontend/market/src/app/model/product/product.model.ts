export class ProductModel {
  constructor(
    public productId: number | string,
    public name: string,
    public price: number,
    public shopId: BigInteger,
    public shopName: string,
    public productImage: string,
    public shopImage: string,
    public description?: string,
    public count: number = 1
  ) {}
}
