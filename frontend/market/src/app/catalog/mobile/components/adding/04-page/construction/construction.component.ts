import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MobileDtoFull} from "../../../../../../model/mobile/mobile-dto";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {mobileProperties} from "../../../../../../../assets/properties/mobile/properties";

@Component({
  selector: 'app-construction',
  templateUrl: './construction.component.html',
  styleUrls: ['./construction.component.css']
})
export class ConstructionComponent implements OnInit {

  @Input("page") page: any;
  @Input("mobileDtoFull") mobileDtoFull?: MobileDtoFull;
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
        housingMaterial: [this.mobileDtoFull?.housingMaterial != null ? this.mobileDtoFull?.housingMaterial :
          this.housingMaterials[0]],
        color: [this.mobileDtoFull?.color != null ? this.mobileDtoFull?.color : this.colors[0]],
        simFormat: [this.mobileDtoFull?.simFormat != null ? this.mobileDtoFull?.simFormat : this.simFormats[0]],
        simCardSlot: [this.mobileDtoFull?.simCardSlot != null ? this.mobileDtoFull?.simCardSlot : null,
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
      this.mobileDtoFull.housingMaterial = this.controls.housingMaterial.value;
      this.mobileDtoFull.color = this.controls.color.value;
      this.mobileDtoFull.simFormat = this.controls.simFormat.value;
      this.mobileDtoFull.simCardSlot = this.controls.simCardSlot.value;
    }
  }
}
