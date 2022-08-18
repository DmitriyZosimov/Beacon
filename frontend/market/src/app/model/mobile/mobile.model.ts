import {MobileMainImage} from "./mobile-image";

export class MobileModel {
  constructor(public mobileId?: string,
              public brand?: string,
              public model?: string,
              public os?: string,
              public screenSize?: string,
              public displayResolution?: string,
              public displayTechnology?: string,
              public ram?: number,
              public storageCapacity?: number,
              public chipsetModel?: string,
              public cameraResolution?: string,
              public simCardSlot?: string,
              public battery?: number,
              public color?: string,
              public releaseYear?: string,
              public mainImage?: MobileMainImage) {}
}
