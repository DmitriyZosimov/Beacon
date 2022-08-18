import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";

import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";
import {MobileFullModel} from "../../../../../../model/mobile";

@Component({
  selector: 'app-interfaces',
  templateUrl: './interfaces.component.html',
  styleUrls: ['./interfaces.component.css']
})
export class InterfacesComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileFull") mobileFull?: MobileFullModel;
  @Output() outputPage = new EventEmitter<number>();

  form!: FormGroup;
  submitted = false;

  bluetoothVersions = mobileProperties.bluetoothVersions;
  audioOutputVersions = mobileProperties.audioOutputVersions;
  wifiVersions = mobileProperties.wifiVersions;
  connections = mobileProperties.connections;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        bluetooth: [this.mobileFull?.bluetooth ? this.mobileFull?.bluetooth : false],
        bluetoothVersion: [this.mobileFull?.bluetoothVersion != null ? this.mobileFull?.bluetoothVersion : null],
        audioOutput: [this.mobileFull?.audioOutput ? this.mobileFull?.audioOutput : false],
        audioOutputVersion: [this.mobileFull?.audioOutputVersion != null ? this.mobileFull?.audioOutputVersion : null],
        wifi: [this.mobileFull?.wifi ? this.mobileFull?.wifi : false],
        wifiVersion: [this.mobileFull?.wifiVersion != null ? this.mobileFull?.wifiVersion : null],
        connection: [this.mobileFull?.connection != null ? this.mobileFull?.connection : this.connections[0]],
        nfc: [this.mobileFull?.nfc ? this.mobileFull?.nfc : false]
      });

    this.checkBluetoothProperties();
    this.checkAudioOutputProperties();
    this.checkWifiProperties();
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
      this.mobileFull.bluetooth = this.controls.bluetooth.value;
      this.mobileFull.bluetoothVersion = this.controls.bluetoothVersion.value;
      this.mobileFull.audioOutput = this.controls.audioOutput.value;
      this.mobileFull.audioOutputVersion = this.controls.audioOutputVersion.value;
      this.mobileFull.wifi = this.controls.wifi.value;
      this.mobileFull.wifiVersion = this.controls.wifiVersion.value;
      this.mobileFull.connection = this.controls.connection.value;
      this.mobileFull.nfc = this.controls.nfc.value;
    }
  }

  private checkBluetoothProperties() {
    this.form.get('bluetooth')?.valueChanges.subscribe(value => {
      if (value) {
        this.form.get('bluetoothVersion')?.setValue(this.bluetoothVersions[0]);
      } else {
        this.form.get('bluetoothVersion')?.setValue(null);
      }
      this.form.get('bluetoothVersion')?.updateValueAndValidity();
    });
  }

  private checkAudioOutputProperties() {
    this.form.get('audioOutput')?.valueChanges.subscribe(value => {
      if (value) {
        this.form.get('audioOutputVersion')?.setValue(this.audioOutputVersions[0]);
      } else {
        this.form.get('audioOutputVersion')?.setValue(null);
      }
      this.form.get('audioOutputVersion')?.updateValueAndValidity();
    });
  }

  private checkWifiProperties() {
    this.form.get('wifi')?.valueChanges.subscribe(value => {
      if (value) {
        this.form.get('wifiVersion')?.setValue(this.wifiVersions[0]);
      } else {
        this.form.get('wifiVersion')?.setValue(null);
      }
      this.form.get('wifiVersion')?.updateValueAndValidity();
    });
  }

}
