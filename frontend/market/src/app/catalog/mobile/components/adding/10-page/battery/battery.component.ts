import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";
import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";

@Component({
  selector: 'app-battery',
  templateUrl: './battery.component.html',
  styleUrls: ['./battery.component.css']
})
export class BatteryComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileDtoFull") mobileDtoFull?: MobileDtoFull;
  @Output() outputPage = new EventEmitter<number>();

  form!: FormGroup;
  submitted = false;

  batteryTypes = mobileProperties.batteryTypes;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        batteryType: [this.mobileDtoFull?.batteryType != null ? this.mobileDtoFull?.batteryType : this.batteryTypes[0]],
        battery: [this.mobileDtoFull?.battery != null ? this.mobileDtoFull?.battery : null,
          [Validators.required, Validators.min]],
        chargeTime: [this.mobileDtoFull?.chargeTime != null ? this.mobileDtoFull?.chargeTime : null]
      });
  }

  onNext() {
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.saveToMobileDtoFull();
    console.log(JSON.stringify(this.mobileDtoFull, null, 2));
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

  private saveToMobileDtoFull() {
    if (this.mobileDtoFull != null) {
      this.mobileDtoFull.battery = this.controls.battery.value;
      this.mobileDtoFull.batteryType = this.controls.batteryType.value;
      this.mobileDtoFull.chargeTime = this.controls.chargeTime.value;
    }
  }

}
