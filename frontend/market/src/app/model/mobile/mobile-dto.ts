import {MobileMainImage, MobileNotMainImage} from "./mobile-image";

export class MobileDto {
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

export class MobileDtoFull {
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
              public type?: string,
              public osVersion?: string,
              public processorClockFrequency?: number,
              public coresNumber?: number,
              public technicalProcess?: number,
              public housingMaterial?: string,
              public simFormat?: string,
              public length?: number,
              public width?: number,
              public height?: number,
              public weight?: number,
              public mainCamerasNumber?: number,
              public builtInFlash?: boolean,
              public automaticFocus?: boolean,
              public opticalStabilization?: boolean,
              public mainCamera?: boolean,
              public mainCameraAperture?: string,
              public frontCamera?: boolean,
              public frontCameraResolution?: string,
              public frontCameraAperture?: string,
              public gps?: boolean,
              public glonass?: boolean,
              public beidou?: boolean,
              public edge?: boolean,
              public hspa?: boolean,
              public hspaPlus?: boolean,
              public lte?: boolean,
              public fiveG?: boolean,
              public bluetooth?: boolean,
              public bluetoothVersion?: string,
              public audioOutput?: boolean,
              public audioOutputVersion?: string,
              public wifi?: boolean,
              public wifiVersion?: string,
              public connection?: string,
              public nfc?: boolean,
              public batteryType?: string,
              public chargeTime?: string,
              public mainImage?: MobileMainImage,
              public notMainImages?: Array<MobileNotMainImage>
              ) {}
}
