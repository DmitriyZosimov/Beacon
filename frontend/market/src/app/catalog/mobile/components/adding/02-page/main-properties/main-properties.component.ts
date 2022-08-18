import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";
import {MobileFullModel} from "../../../../../../model/mobile";

@Component({
  selector: 'app-main-properties',
  templateUrl: './main-properties.component.html',
  styleUrls: ['./main-properties.component.css']
})
export class MainPropertiesComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileFull") mobileFull?: MobileFullModel;
  @Output() outputPage = new EventEmitter<number>();

  form!: FormGroup;
  submitted = false;

  oss = mobileProperties.os;
  types = mobileProperties.types;
  displayTechnologies = mobileProperties.displayTechnologies;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        type: [this.mobileFull?.type != null ? this.mobileFull?.type : this.types[0]],
        os: [this.mobileFull?.os != null ? this.mobileFull?.os : this.oss[0]],
        osVersion: [this.mobileFull?.osVersion != null ? this.mobileFull?.osVersion : null, Validators.required],
        screenSize: [this.mobileFull?.screenSize != null ? this.mobileFull?.screenSize : null,
          [Validators.required, Validators.min]],
        displayResolution: [this.mobileFull?.displayResolution != null ? this.mobileFull?.displayResolution : null,
          [Validators.required, Validators.pattern('[0-9]{0,4}[xX]{1}[0-9]{0,4}')]],
        displayTechnology: [this.mobileFull?.displayTechnology != null ? this.mobileFull?.displayTechnology :
          this.displayTechnologies[0]],
        ram: [this.mobileFull?.ram != null ? this.mobileFull?.ram : null, [Validators.required, Validators.min]],
        storageCapacity: [this.mobileFull?.storageCapacity != null ? this.mobileFull?.storageCapacity : null,
          [Validators.required, Validators.min]]
      });
  }

  onNext() {
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.saveToMobileFull();
    console.log(JSON.stringify(this.mobileFull, null, 2));
    this.page++;
    this.outputPage.emit(this.page);
  }

  onBack() {
    this.page--;
    this.outputPage.emit(this.page);
  }

  get controls(): { [p: string]: AbstractControl } {
    return this.form.controls;
  }

  private saveToMobileFull() {
    if (this.mobileFull != null) {
      this.mobileFull.type = this.controls.type.value;
      this.mobileFull.os = this.controls.os.value;
      this.mobileFull.osVersion = this.controls.osVersion.value;
      this.mobileFull.screenSize = this.controls.screenSize.value;
      this.mobileFull.displayResolution = this.controls.displayResolution.value;
      this.mobileFull.displayTechnology = this.controls.displayTechnology.value;
      this.mobileFull.ram = this.controls.ram.value;
      this.mobileFull.storageCapacity = this.controls.storageCapacity.value;
    }
  }

}
