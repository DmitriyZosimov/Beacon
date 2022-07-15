import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";

@Component({
  selector: 'app-main-properties',
  templateUrl: './main-properties.component.html',
  styleUrls: ['./main-properties.component.css']
})
export class MainPropertiesComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileDtoFull") mobileDtoFull?: MobileDtoFull;
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
        type: [this.mobileDtoFull?.type != null ? this.mobileDtoFull?.type : this.types[0]],
        os: [this.mobileDtoFull?.os != null ? this.mobileDtoFull?.os : this.oss[0]],
        osVersion: [this.mobileDtoFull?.osVersion != null ? this.mobileDtoFull?.osVersion : null, Validators.required],
        screenSize: [this.mobileDtoFull?.screenSize != null ? this.mobileDtoFull?.screenSize : null,
          [Validators.required, Validators.min]],
        displayResolution: [this.mobileDtoFull?.displayResolution != null ? this.mobileDtoFull?.displayResolution : null,
          [Validators.required, Validators.pattern('[0-9]{0,4}[xX]{1}[0-9]{0,4}')]],
        displayTechnology: [this.mobileDtoFull?.displayTechnology != null ? this.mobileDtoFull?.displayTechnology :
          this.displayTechnologies[0]],
        ram: [this.mobileDtoFull?.ram != null ? this.mobileDtoFull?.ram : null, [Validators.required, Validators.min]],
        storageCapacity: [this.mobileDtoFull?.storageCapacity != null ? this.mobileDtoFull?.storageCapacity : null,
          [Validators.required, Validators.min]]
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
      this.mobileDtoFull.type = this.controls.type.value;
      this.mobileDtoFull.os = this.controls.os.value;
      this.mobileDtoFull.osVersion = this.controls.osVersion.value;
      this.mobileDtoFull.screenSize = this.controls.screenSize.value;
      this.mobileDtoFull.displayResolution = this.controls.displayResolution.value;
      this.mobileDtoFull.displayTechnology = this.controls.displayTechnology.value;
      this.mobileDtoFull.ram = this.controls.ram.value;
      this.mobileDtoFull.storageCapacity = this.controls.storageCapacity.value;
    }
  }

}
