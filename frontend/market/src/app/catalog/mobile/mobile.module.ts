import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {MobileRoutingModule} from './mobile-routing.module';
import {MobileComponent} from './mobile.component';
import {FilterComponent} from './components/filter/filter.component';
import {ProductListComponent} from './components/product-list/product-list.component';
import {MobileService} from "../../service/mobile/mobile.service";
import {ProductComponent} from './components/product/product.component';
import {CarouselComponent} from './components/product/carousel/carousel.component';
import {ImageListComponent} from './components/product/image-list/image-list.component';
import {AddingComponent} from './components/adding/adding.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ImageComponent} from './components/adding/11-page/image/image.component';
import {MainPropertiesComponent} from './components/adding/02-page/main-properties/main-properties.component';
import {CommonPropertiesComponent} from './components/adding/01-page/common-properties/common-properties.component';
import {ProcessorComponent} from './components/adding/03-page/processor/processor.component';
import {ConstructionComponent} from './components/adding/04-page/construction/construction.component';
import {SizeComponent} from './components/adding/05-page/size/size.component';
import {CameraComponent} from './components/adding/06-page/camera/camera.component';
import {NavigationComponent} from './components/adding/07-page/navigation/navigation.component';
import {DataTransmissionComponent} from './components/adding/08-page/data-transmission/data-transmission.component';
import {InterfacesComponent} from './components/adding/09-page/interfaces/interfaces.component';
import {BatteryComponent} from './components/adding/10-page/battery/battery.component';
import {ReviewComponent} from './components/adding/12-page/review/review.component';


@NgModule({
  declarations: [
    MobileComponent,
    FilterComponent,
    ProductListComponent,
    ProductComponent,
    CarouselComponent,
    ImageListComponent,
    AddingComponent,
    ImageComponent,
    MainPropertiesComponent,
    CommonPropertiesComponent,
    ProcessorComponent,
    ConstructionComponent,
    SizeComponent,
    CameraComponent,
    NavigationComponent,
    DataTransmissionComponent,
    InterfacesComponent,
    BatteryComponent,
    ReviewComponent
  ],
  imports: [
    CommonModule,
    MobileRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    MobileService
  ]
})
export class MobileModule {
}
