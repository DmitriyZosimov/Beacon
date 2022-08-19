import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {MobileRoutingModule} from './mobile-routing.module';
import {FilterComponent, ProductListComponent} from './components';
import {CarouselComponent, ImageListComponent} from './components/product';
import {
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
    MobileRoutingModule.components,
    FilterComponent,
    ProductListComponent,
    CarouselComponent,
    ImageListComponent,
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
  ]
})
export class MobileModule {
}
