import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";
import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";

@Component({
  selector: 'app-interfaces',
  templateUrl: './interfaces.component.html',
  styleUrls: ['./interfaces.component.css']
})
export class InterfacesComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileDtoFull") mobileDtoFull?: MobileDtoFull;
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
        bluetooth: [this.mobileDtoFull?.bluetooth ? this.mobileDtoFull?.bluetooth : false],
        bluetoothVersion: [this.mobileDtoFull?.bluetoothVersion != null ? this.mobileDtoFull?.bluetoothVersion : null],
        audioOutput: [this.mobileDtoFull?.audioOutput ? this.mobileDtoFull?.audioOutput : false],
        audioOutputVersion: [this.mobileDtoFull?.audioOutputVersion != null ? this.mobileDtoFull?.audioOutputVersion : null],
        wifi: [this.mobileDtoFull?.wifi ? this.mobileDtoFull?.wifi : false],
        wifiVersion: [this.mobileDtoFull?.wifiVersion != null ? this.mobileDtoFull?.wifiVersion : null],
        connection: [this.mobileDtoFull?.connection != null ? this.mobileDtoFull?.connection : this.connections[0]],
        nfc: [this.mobileDtoFull?.nfc ? this.mobileDtoFull?.nfc : false]
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
      this.mobileDtoFull.bluetooth = this.controls.bluetooth.value;
      this.mobileDtoFull.bluetoothVersion = this.controls.bluetoothVersion.value;
      this.mobileDtoFull.audioOutput = this.controls.audioOutput.value;
      this.mobileDtoFull.audioOutputVersion = this.controls.audioOutputVersion.value;
      this.mobileDtoFull.wifi = this.controls.wifi.value;
      this.mobileDtoFull.wifiVersion = this.controls.wifiVersion.value;
      this.mobileDtoFull.connection = this.controls.connection.value;
      this.mobileDtoFull.nfc = this.controls.nfc.value;
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
