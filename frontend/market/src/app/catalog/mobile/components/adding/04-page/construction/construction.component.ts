import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";
import {MobileFullModel} from "../../../../../../model/mobile";

@Component({
  selector: 'app-construction',
  templateUrl: './construction.component.html',
  styleUrls: ['./construction.component.css']
})
export class ConstructionComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileFull") mobileFull?: MobileFullModel;
  @Output() outputPage = new EventEmitter<number>();

  form!: FormGroup;
  submitted = false;

  housingMaterials = mobileProperties.housingMaterials;
  colors = mobileProperties.colors;
  simFormats = mobileProperties.simFormats;


  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        housingMaterial: [this.mobileFull?.housingMaterial != null ? this.mobileFull?.housingMaterial :
          this.housingMaterials[0]],
        color: [this.mobileFull?.color != null ? this.mobileFull?.color : this.colors[0]],
        simFormat: [this.mobileFull?.simFormat != null ? this.mobileFull?.simFormat : this.simFormats[0]],
        simCardSlot: [this.mobileFull?.simCardSlot != null ? this.mobileFull?.simCardSlot : null,
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
      this.mobileFull.housingMaterial = this.controls.housingMaterial.value;
      this.mobileFull.color = this.controls.color.value;
      this.mobileFull.simFormat = this.controls.simFormat.value;
      this.mobileFull.simCardSlot = this.controls.simCardSlot.value;
    }
  }
}
