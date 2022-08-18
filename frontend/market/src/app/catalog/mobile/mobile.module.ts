import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {MobileRoutingModule} from './mobile-routing.module';
import {MobileComponent} from './mobile.component';
import {FilterComponent, ProductListComponent} from './components';
import {MobileService} from "../../service/mobile/mobile.service";
import {CarouselComponent, ImageListComponent, ProductComponent} from './components/product';
import {
  AddingComponent,
  BatteryComponent,
  CameraComponent,
  CommonPropertiesComponent,
  ConstructionComponent,
  DataTransmissionComponent,
  ImageComponent,
  InterfacesComponent,
  MainPropertiesComponent,
  NavigationComponent,
  ProcessorComponent,
  ReviewComponent,
  SizeComponent
} from './components/adding';


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
