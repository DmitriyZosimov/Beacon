import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";
import {MobileFullModel} from "../../../../../../model/mobile";

@Component({
  selector: 'app-battery',
  templateUrl: './battery.component.html',
  styleUrls: ['./battery.component.css']
})
export class BatteryComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileFull") mobileFull?: MobileFullModel;
  @Output() outputPage = new EventEmitter<number>();

  form!: FormGroup;
  submitted = false;

  batteryTypes = mobileProperties.batteryTypes;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        batteryType: [this.mobileFull?.batteryType != null ? this.mobileFull?.batteryType : this.batteryTypes[0]],
        battery: [this.mobileFull?.battery != null ? this.mobileFull?.battery : null,
          [Validators.required, Validators.min]],
        chargeTime: [this.mobileFull?.chargeTime != null ? this.mobileFull?.chargeTime : null]
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
      this.mobileFull.battery = this.controls.battery.value;
      this.mobileFull.batteryType = this.controls.batteryType.value;
      this.mobileFull.chargeTime = this.controls.chargeTime.value;
    }
  }

}
